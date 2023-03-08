package com.example.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Lector;
import com.example.biblioteca.entities.Tarjeta;
import com.example.biblioteca.interfaces.ILectorService;
import com.example.biblioteca.responses.ResponseBase;

@RestController
@RequestMapping("/lectores")
public class LectorController {

	@Autowired
	private ILectorService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getById/{idLector}")
	public ResponseEntity<?> getById(@PathVariable("idLector") Long idLector) {
		try {
			return ResponseEntity.ok(service.getById(idLector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Lector lector) {
		try {
			return ResponseEntity.ok(service.save(lector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Lector lector) {
		try {
			return ResponseEntity.ok(service.update(lector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getByMatcher")
	public ResponseEntity<?> getByMatcher(@RequestBody Lector lector) {
		try {
			return ResponseEntity.ok(service.getByMatcher(lector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	//Logica y calculo no, pero si puedes setear datos de entrada necesarios
	@GetMapping("/castigados")
	public ResponseEntity<?> castigados() {
		try {
			Lector lector = new Lector();
			Tarjeta tarjeta = new Tarjeta();
			tarjeta.setActive(false);
			lector.setTarjeta(tarjeta);
			
			return ResponseEntity.ok(service.getByMatcher(lector));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
}
