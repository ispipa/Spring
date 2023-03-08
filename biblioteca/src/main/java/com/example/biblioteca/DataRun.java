package com.example.biblioteca;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.biblioteca.common.Area;
import com.example.biblioteca.entities.Copia;
import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Libro;
import com.example.biblioteca.entities.Prestamo;
import com.example.biblioteca.entities.Tarjeta;
import com.example.biblioteca.repositories.CopiaRepository;
import com.example.biblioteca.repositories.LectorRespository;
import com.example.biblioteca.repositories.LibroRepository;
import com.example.biblioteca.repositories.PrestamoRepository;
import com.example.biblioteca.repositories.TarjetaRepository;

@Component
public class DataRun implements ApplicationRunner{

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private CopiaRepository copiaRepository;
	
	@Autowired
	private LectorRespository lectorRepository;
	
	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		prestamoRepository.deleteAll();
//		tarjetaRepository.deleteAll();
//		lectorRepository.deleteAll();
//		copiaRepository.deleteAll();
//		libroRepository.deleteAll();
//		
//		Libro libro1 = new Libro(1L, null, "Harry Potter", "J. K. Rowling", Area.AVENTURAS);
//		Libro libro2 = new Libro(2L, null, "Bajo la misma estrella", "Jogn Green", Area.ROMANCE);
//		Libro libro3 = new Libro(3L, null, "Dune", "Frank Herbert", Area.CIENCIA_FICCION);
//		Libro libro4 = new Libro(4L, null, "Perdida", "Gillian Flynn", Area.SUSPENSE);
//		
//		Libro libro1saved = libroRepository.save(libro1);
//		Libro libro2saved = libroRepository.save(libro2);
//		Libro libro3saved = libroRepository.save(libro3);
//		Libro libro4saved = libroRepository.save(libro4);
//		
//		Copia copia1 = new Copia(1L, libro1saved, null, "Editorial 1", new Date(2000, 1, 1));
//		Copia copia2 = new Copia(2L, libro1saved, null, "Editorial 2", new Date(2001, 1, 1));
//		Copia copia3 = new Copia(3L, libro1saved, null, "Editorial 3", new Date(2002, 1, 1));
//		Copia copia4 = new Copia(4L, libro1saved, null, "Editorial 4", new Date(2003, 2, 1));
//		Copia copia5 = new Copia(5L, libro2saved, null, "Editorial 1", new Date(2000, 4, 3));
//		Copia copia6 = new Copia(6L, libro2saved, null, "Editorial 1", new Date(2001, 1, 1));
//		Copia copia7 = new Copia(7L, libro2saved, null, "Editorial 3", new Date(2002, 4, 1));
//		Copia copia8 = new Copia(8L, libro3saved, null, "Editorial 4", new Date(2003, 3, 3));
//		Copia copia9 = new Copia(9L, libro4saved, null, "Editorial 1", new Date(2000, 1, 1));
//		Copia copia10 = new Copia(10L, libro4saved, null, "Editorial 3", new Date(2001, 4, 1));
//		Copia copia11 = new Copia(11L, libro4saved, null, "Editorial 3", new Date(2002, 5, 1));
//		Copia copia12 = new Copia(12L, libro4saved, null, "Editorial 4", new Date(2003, 5, 2));
//		
//		Copia copia1saved = copiaRepository.save(copia1);
//		Copia copia2saved = copiaRepository.save(copia2);
//		Copia copia3saved = copiaRepository.save(copia3);
//		Copia copia4saved = copiaRepository.save(copia4);
//		Copia copia5saved = copiaRepository.save(copia5);
//		Copia copia6saved = copiaRepository.save(copia6);
//		Copia copia7saved = copiaRepository.save(copia7);
//		Copia copia8saved = copiaRepository.save(copia8);
//		Copia copia9saved = copiaRepository.save(copia9);
//		Copia copia10saved = copiaRepository.save(copia10);
//		Copia copia11saved = copiaRepository.save(copia11);
//		Copia copia12saved = copiaRepository.save(copia12);
//		
//		Lector lector1 = new Lector(1L, null, null, "Persona a", "12345678A", new Date(2000, 1, 1));
//		Lector lector2 = new Lector(2L, null, null, "Persona b", "22345678A", new Date(2000, 1, 1));
//		Lector lector3 = new Lector(3L, null, null, "Persona c", "32345678A", new Date(2000, 1, 1));
//		Lector lector4 = new Lector(4L, null, null, "Persona d", "42345678A", new Date(2000, 1, 1));
//		Lector lector5 = new Lector(5L, null, null, "Persona e", "52345678A", new Date(2000, 1, 1));
//		
//		Lector lector1saved = lectorRepository.save(lector1);
//		Lector lector2saved = lectorRepository.save(lector2);
//		Lector lector3saved = lectorRepository.save(lector3);
//		Lector lector4saved = lectorRepository.save(lector4);
//		Lector lector5saved = lectorRepository.save(lector5);
//		
//		Tarjeta tarjeta1 = new Tarjeta(1L, lector1saved, new Date(2000, 1, 1), new Date(2024, 1, 1), null, true);
//		Tarjeta tarjeta2 = new Tarjeta(2L, lector2saved, new Date(2000, 1, 1), new Date(2024, 1, 1), null, true);
//		Tarjeta tarjeta3 = new Tarjeta(3L, lector3saved, new Date(2000, 1, 1), new Date(2024, 1, 1), null, true);
//		Tarjeta tarjeta4 = new Tarjeta(4L, lector4saved, new Date(2000, 1, 1), new Date(2024, 1, 1), null, true);
//		Tarjeta tarjeta5 = new Tarjeta(5L, lector5saved, new Date(2000, 1, 1), new Date(2024, 1, 1), null, true);
//		
//		Tarjeta tarjeta1saved = tarjetaRepository.save(tarjeta1);
//		Tarjeta tarjeta2saved = tarjetaRepository.save(tarjeta2);
//		Tarjeta tarjeta3saved = tarjetaRepository.save(tarjeta3);
//		Tarjeta tarjeta4saved = tarjetaRepository.save(tarjeta4);
//		Tarjeta tarjeta5saved = tarjetaRepository.save(tarjeta5);
//		
//		Prestamo prestamo1 = new Prestamo(copia1saved.getIdCopia(), copia1saved, lector1saved, new Date(2023, 2, 20), new Date(2023, 2, 28), true);
//		Prestamo prestamo2 = new Prestamo(copia9saved.getIdCopia(), copia9saved, lector2saved, new Date(2022, 2, 20), new Date(2022, 2, 28), false);
//		Prestamo prestamo3 = new Prestamo(copia4saved.getIdCopia(), copia4saved, lector3saved, new Date(2023, 2, 20), new Date(2023, 2, 28), true);
//		Prestamo prestamo4 = new Prestamo(copia11saved.getIdCopia(), copia11saved, lector5saved, new Date(2023, 2, 20), new Date(2023, 2, 28), true);
//		
//		Prestamo prestamo1saved = prestamoRepository.save(prestamo1);
//		Prestamo prestamo2saved = prestamoRepository.save(prestamo2);
//		Prestamo prestamo3saved = prestamoRepository.save(prestamo3);
//		Prestamo prestamo4saved = prestamoRepository.save(prestamo4);
		
	}

}
