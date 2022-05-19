package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.exception.ResourceNotFoundException;
import com.pruebas.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	@Autowired
	PersonaDAO personaDAO;

	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		this.personaDAO.save(persona);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar(){
		return this.personaDAO.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Persona listarPorId(@PathVariable("id") Integer id){
		return this.personaDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Persona "+id+" no encontrada"));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		this.personaDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		this.personaDAO.save(persona);
	}
}
