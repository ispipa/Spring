package com.example.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.common.Codigos;
import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.common.Errores;
import com.example.biblioteca.entities.Prestamo;
import com.example.biblioteca.interfaces.IPrestamoService;
import com.example.biblioteca.responses.ResponseBase;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

	@Autowired
	private IPrestamoService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getById/{idPrestamo}")
	public ResponseEntity<?> getById(@PathVariable("idPrestamo") Long idPrestamo) {
		try {
			return ResponseEntity.ok(service.getById(idPrestamo));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Prestamo prestamo) {
		try {
			if(prestamo.getIdCopia() == null || prestamo.getLector().getIdLector() == null)
				return ResponseEntity.badRequest().body(new ResponseBase(Errores.NULOS));
			
			return ResponseEntity.ok(service.save(prestamo));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Prestamo prestamo) {
		try {
			return ResponseEntity.ok(service.update(prestamo));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@DeleteMapping("/delete/{idCopia}")
	public ResponseEntity<?> terminarPrestamo(@PathVariable("idCopia") Long idCopia) {
		try {
			service.deleteById(idCopia);
			return ResponseEntity.ok(new ResponseBase(Codigos.CORRECTO));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getAllByIdLector/{idLector}")
	public ResponseEntity<?> getAllByIdLector(@PathVariable("idLector") Long idLector) {
		try {
			return ResponseEntity.ok(service.getAllByIdLector(idLector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getByMatcher")
	public ResponseEntity<?> getByMatcher(@RequestBody Prestamo prestamo){
		try {
			return ResponseEntity.ok(service.getAllMatch(prestamo));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/devolverPrestamo/{id}")
	public ResponseEntity<?> devolverPrestamo(@PathVariable Long idCopia) {
		try {
			return ResponseEntity.ok(service.devolverPrestamo(idCopia));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
}
