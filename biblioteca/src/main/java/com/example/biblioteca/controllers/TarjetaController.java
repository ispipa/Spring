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
import com.example.biblioteca.entities.Tarjeta;
import com.example.biblioteca.interfaces.ITarjetaService;
import com.example.biblioteca.responses.ResponseBase;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

	@Autowired
	private ITarjetaService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getById/{idTarjeta}")
	public ResponseEntity<?> getById(@PathVariable("idTarjeta") Long idTarjeta) {
		try {
			return ResponseEntity.ok(service.getById(idTarjeta));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Tarjeta tarjeta) {
		try {
			return ResponseEntity.ok(service.save(tarjeta));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Tarjeta tarjeta) {
		try {
			return ResponseEntity.ok(service.update(tarjeta));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
}
