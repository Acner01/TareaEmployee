package edu.cesur.employee.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.cesur.employee.model.Employee;
import jakarta.websocket.server.PathParam;

@RestController
public class SaludoEmplController {
	@GetMapping("/saludo")
	public String saluda() {
		return "Hello Spring";
	}
	
	
	@GetMapping("/saludo/{nombre}/{apellido}")
	public String saludaPorNombre(@PathVariable String nombre, @PathVariable String apellido) {
		return "Hola, " + nombre +  " " + apellido;
	}
}
