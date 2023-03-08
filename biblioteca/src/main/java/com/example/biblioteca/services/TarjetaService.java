package com.example.biblioteca.services;

import java.time.LocalDate;
import java.time.ZoneId;
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
import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Tarjeta;
import com.example.biblioteca.interfaces.ITarjetaService;
import com.example.biblioteca.repositories.LectorRespository;
import com.example.biblioteca.repositories.TarjetaRepository;

@Service
public class TarjetaService implements ITarjetaService{

	@Autowired
	private TarjetaRepository repositorio;
	
	@Autowired
	private LectorRespository lectorRepositorio;

	@Override
	public List<Tarjeta> getAll() throws ErrorException {
		List<Tarjeta> tarjetas = repositorio.findAll();
		if(tarjetas.isEmpty())
			throw new ErrorException(Errores.VACIO, HttpStatus.OK);
		return tarjetas;
	}

	@Override
	public Tarjeta getById(Long id) throws ErrorException {
		return repositorio.findById(id).orElseThrow(() -> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
	}

	@Override
	public Tarjeta save(Tarjeta tarjeta) {
		Lector lector = lectorRepositorio.findById(tarjeta.getLector().getIdLector()).orElseThrow(() -> new ErrorException(Errores.NO_ENCONTRADO, HttpStatus.OK));
		
		tarjeta.setFdCreacion(new Date());
		tarjeta.setActive(true);
		
		return repositorio.save(tarjeta);
	}

	//dependiendo como se vea, se puede hacer logica de comprobacion en otros lugares y utilizar este metodo para actualizar directamente sin comprobacion
	@Override
	public Tarjeta update(Tarjeta tarjeta) throws ErrorException {
		return repositorio.save(tarjeta);
	}

	//No se utiliza
	@Override
	public void deleteById(Long id) throws ErrorException {
		this.getById(id);
		repositorio.deleteById(id);
	}

	@Override
	public void castigarTarjeta(Tarjeta tarjeta) throws ErrorException {
		tarjeta.setFdCastigo(Date.from(LocalDate.now().plusDays(Constantes.TIEMPO_CASTIGO).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tarjeta.setActive(false);
		repositorio.save(tarjeta);
	}

	@Override
	public List<Tarjeta> getAllMatch(Tarjeta tarjeta) throws ErrorException {
		ExampleMatcher matcher = ExampleMatcher
                .matchingAll().withStringMatcher(StringMatcher.CONTAINING)
                .withIgnoreNullValues();

        return repositorio.findAll(Example.of(tarjeta, matcher));
	}

	//En milisegundos
//	@Scheduled(fixedRate = 6*60*60*1000)
	private void revisarTarjetas() {
		Tarjeta tarjetaExample = new Tarjeta();

		tarjetaExample.setActive(false);
		List<Tarjeta> tarjetas = this.getAllMatch(tarjetaExample);

		//comprobar su estado por cada uno
		for (Tarjeta tarjeta : tarjetas) {
			comprobarTarjeta(tarjeta);
		}
		
	}

	//La fecha de caducidad y creacion es un lio debido a que necesitariamos un historico para que tenga sentido
	@Override
	public boolean comprobarTarjeta(Tarjeta tarjeta) throws ErrorException {
		if(tarjeta.getActive()==false) {
			if(tarjeta.getFdCastigo()!=null) {
				if(tarjeta.getFdCastigo().before(new Date())) {
					tarjeta.setActive(true);
					tarjeta.setFdCastigo(null);
					this.update(tarjeta);
					return true;
				}
			}
			return false;
		}
		
		return false;
	}
}
