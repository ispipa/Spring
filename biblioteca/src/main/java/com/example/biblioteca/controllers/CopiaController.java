package com.example.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.common.ErrorException;
import com.example.biblioteca.entities.Copia;
import com.example.biblioteca.interfaces.ICopiaService;
import com.example.biblioteca.responses.ResponseBase;

@RestController
@RequestMapping("/copias")
public class CopiaController {

	@Autowired
	private ICopiaService service;
	
	//Suele ser recogido por un dto especial
	@GetMapping("/getAllPaginacion")
	public ResponseEntity<?> getAllPaginacion(
			@RequestParam("inicio") int inicio, 
			@RequestParam("fin") int fin,
			@RequestParam("sort") String sort,
			@RequestParam("direction") String direction,
			@RequestBody Copia copia) {
		try {
			return ResponseEntity.ok(service.getAllPaginacion(copia,inicio,fin, sort, direction));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getById/{idCopia}")
	public ResponseEntity<?> getById(@PathVariable("idCopia") Long idCopia) {
		try {
			return ResponseEntity.ok(service.getById(idCopia));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Copia copia) {
		try {
			return ResponseEntity.ok(service.save(copia));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Copia copia) {
		try {
			return ResponseEntity.ok(service.update(copia));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
}
