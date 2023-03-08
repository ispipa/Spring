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
import com.example.biblioteca.entities.Libro;
import com.example.biblioteca.interfaces.ILibrosService;
import com.example.biblioteca.requests.LibroSearchRequest;
import com.example.biblioteca.responses.ResponseBase;

@RestController
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private ILibrosService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(service.getAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	//Ejercicio 2, entra info simple del libro y devuelve info del libro con las copias disponibles, y tambien las copias
	@GetMapping("/getAllSearch")
	public ResponseEntity<?> getAllSearch( @RequestBody LibroSearchRequest libro) {
		try {
			return ResponseEntity.ok(service.getAllSearch(libro));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@GetMapping("/getById/{idLibro}")
	public ResponseEntity<?> getById(@PathVariable("idLibro") Long idLibro) {
		try {
			return ResponseEntity.ok(service.getById(idLibro));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Libro libro) {
		try {
			return ResponseEntity.ok(service.save(libro));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Libro libro) {
		try {
			return ResponseEntity.ok(service.update(libro));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getStatus());
		}
	}
}
