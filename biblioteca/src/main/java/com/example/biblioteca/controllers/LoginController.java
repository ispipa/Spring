package com.example.biblioteca.controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.common.Codigos;
import com.example.biblioteca.config.JwtUtils;
import com.example.biblioteca.config.UserDetailsImpl;
import com.example.biblioteca.entities.Usuario;
import com.example.biblioteca.repositories.UserRepository;
import com.example.biblioteca.responses.LoginResponse;
import com.example.biblioteca.responses.ResponseBase;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestHeader("Authorization") String auth) {
		
		String pair=new String(Base64.decodeBase64(auth.substring(6)));
        String userName=pair.split(":")[0];
        String password=pair.split(":")[1];
        
        Authentication authentication=null;
        try {
        	authentication = authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(userName, password));
		} catch (BadCredentialsException e) {
			logger.error("Error en la autenticacion");
			return ResponseEntity.ok(new ResponseBase(Codigos.BAD_CREDENTIALS));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
        
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(authority -> authority.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new LoginResponse(Codigos.CORRECTO, jwt, userName, password, roles.get(0)));
	}
	
	@PostMapping("/registrarse")
	public ResponseEntity<?> registerUser(@RequestBody Usuario usuarioNuevo) {
		if (userRepository.existsByUsername(usuarioNuevo.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new ResponseBase(Codigos.BAD_REQUEST));
		}
		if (userRepository.existsByEmail(usuarioNuevo.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new ResponseBase(Codigos.BAD_REQUEST));
		}
		
		usuarioNuevo.setPassword(encoder.encode(usuarioNuevo.getPassword()));

		//No se esta haciendo comprobacion de rol por el momento
		usuarioNuevo.setRol(usuarioNuevo.getRol());

		userRepository.save(usuarioNuevo);
		return ResponseEntity.ok(new ResponseBase(Codigos.CORRECTO));
	}
}
