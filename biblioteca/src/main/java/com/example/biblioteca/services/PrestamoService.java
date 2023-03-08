package com.example.biblioteca.services;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.biblioteca.common.Constantes;
import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;
import com.example.biblioteca.entities.Copia;
import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Prestamo;
import com.example.biblioteca.entities.Tarjeta;
import com.example.biblioteca.interfaces.IPrestamoService;
import com.example.biblioteca.interfaces.ITarjetaService;
import com.example.biblioteca.repositories.CopiaRepository;
import com.example.biblioteca.repositories.LectorRespository;
import com.example.biblioteca.repositories.PrestamoRepository;
import com.example.biblioteca.repositories.TarjetaRepository;

@Service
public class PrestamoService implements IPrestamoService{

	@Autowired
	private PrestamoRepository repositorio;
	
	@Autowired
	private ITarjetaService tarjetaService;

	@Autowired
	private LectorRespository lectorRepositorio;
	
	@Autowired
	private CopiaRepository copiaRepository;
	
	@Override
	public List<Prestamo> getAll() throws ErrorException {
		List<Prestamo> prestamos = repositorio.findAll();
		if(prestamos.isEmpty())
			throw new ErrorException(Errores.VACIO, HttpStatus.OK);
		return prestamos;
	}

	@Override
	public Prestamo getById(Long id) throws ErrorException {
		return repositorio.findById(id).orElseThrow(() -> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		
	}

	@Override
	public Prestamo save(Prestamo prestamo) {

		//Control de persistencia
		Copia copia = copiaRepository.findById(prestamo.getIdCopia()).orElseThrow(()-> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		if(copia.getPrestamo() !=null && copia.getPrestamo().getActive() == true)
			throw new ErrorException(Errores.COPIA_PRESTADA, HttpStatus.OK);
		prestamo.setCopia(copia);

		Lector lector = lectorRepositorio.findById(prestamo.getLector().getIdLector())
				.orElseThrow(()-> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		
		if(lector.getPrestamos().size() >= Constantes.MAX_PRESTAMOS)
			throw new ErrorException(Errores.MAXIMO_PRESTAMOS, HttpStatus.OK);
		
		//Aqui habria 2 opciones
		//1 una facil de ver al active, si confiamos en que siempre estará bien (deberia)
		if(lector.getTarjeta()!=null && !lector.getTarjeta().getActive()) {
			throw new ErrorException(Errores.TARJETA_CASTIGADA, HttpStatus.OK);
		}
		//2 Con esto nos aseguramos de todo sobre la tarjeta
		if(tarjetaService.comprobarTarjeta(lector.getTarjeta())) {
			throw new ErrorException(Errores.TARJETA_CASTIGADA, HttpStatus.OK);
		}
		
		prestamo.setFdPrestacion(new Date());
		prestamo.setActive(true);
		prestamo.setLector(lector);
		prestamo.setFdDevolver(ponerFechaDevolucion(prestamo.getFdPrestacion()));
		
		return repositorio.save(prestamo);
	}

	@Override
	public Prestamo update(Prestamo prestamo) throws ErrorException {
		this.getById(prestamo.getIdCopia());
		return repositorio.save(prestamo);
	}

	//En realidad en caso de devolver el prestamo lo borramos de la base de datos y hacer historico con ello
	@Override
	public void deleteById(Long id) throws ErrorException {
//		Prestamo prestamo = this.getById(id);
//		//Comprobante de la fecha de devolucion
//		if(!prestamo.getActive() || prestamo.getFdDevolver().before(new Date())) {
//			Tarjeta tarjeta = prestamo.getLector().getTarjeta();
//			tarjeta.setActive(false);
//			tarjeta.setFdCastigo(ponerFechaCastigo());
//			tarjetaRepositorio.save(tarjeta);
//			repositorio.deleteById(id);
//			throw new ErrorException(Errores.COPIA_FD_DEVOLVER, HttpStatus.OK);
//		}
//		
//		repositorio.deleteById(id);
	}

	@Override
	public List<Prestamo> getAllByIdLector(Long idLector) throws ErrorException {
		
		//1 opcion
		lectorRepositorio.findById(idLector).orElseThrow(()-> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		
		Lector lector = new Lector();
		lector.setIdLector(idLector);
		Prestamo prestamo= new Prestamo();
		prestamo.setLector(lector);
		
		ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreNullValues();
		
		List<Prestamo> prestamos = repositorio.findAll(Example.of(prestamo, matcher));
		//return prestamos;
		
		//2 opcion
		Lector lec =lectorRepositorio.findById(idLector).orElseThrow(()-> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		
		return lec.getPrestamos();
	}
	
	private Date ponerFechaDevolucion(Date fdPrestacion) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fdPrestacion);
		cal.add(Calendar.DATE, Constantes.TIEMPO_DEVOLUCION);
		return cal.getTime();
	}

	//Revisar prestamos activos para castigar
//	@Scheduled(fixedRate = 6*60*60*1000)
	private void revisarPrestamos() {
		Prestamo prestamoExample = new Prestamo();
		prestamoExample.setActive(true);
		
		List<Prestamo> prestamos = this.getAllMatch(prestamoExample);
		
		for (Prestamo prestamo : prestamos) {
			comprobarPrestamo(prestamo);
		}
	}

	@Override
	public boolean comprobarPrestamo(Prestamo prestamo) {
		//comprobar prestamos activos y castigar si es necesario
		if(prestamo.getActive() == true) {
			if(prestamo.getFdDevolver().before(new Date())) {
				Tarjeta tarjeta = prestamo.getLector().getTarjeta();
				tarjetaService.castigarTarjeta(tarjeta);
				return false;
			}
			return true;
		}else {
			//se esta comprobando un prestamo ya finalizado
			throw new ErrorException(Errores.PRESTAMO_YA_DEVUELTO);
		}	
	}

	@Override
	public List<Prestamo> getAllMatch(Prestamo prestamo) throws ErrorException {
		ExampleMatcher matcher = ExampleMatcher
                .matchingAll().withStringMatcher(StringMatcher.CONTAINING)
                .withIgnoreNullValues();

        return repositorio.findAll(Example.of(prestamo, matcher));
	}

	@Override
	public boolean devolverPrestamo(Long idCopia) throws ErrorException {
		Prestamo prestamo = this.getById(idCopia);
		comprobarPrestamo(prestamo);
		prestamo.setActive(false);
		repositorio.save(prestamo);
		//Actualizamos la tarjeta, por el si acaso estaba castigado y con esta devolucion vuelve
		tarjetaService.comprobarTarjeta(prestamo.getLector().getTarjeta());
		return true;
	}

}
