package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.ClienteController;
import com.example.demo.entities.Cliente;
import com.example.demo.dto.ResponseDTO;


@RestController
@RequestMapping("/NutriNET")
public class ClienteRest {
	
	@Autowired
	private ClienteController clienteController;
	
	@PostMapping("/Cliente")
	public ResponseDTO<Cliente> agreagarCliente(@RequestBody Cliente cliente){	
		return clienteController.create(cliente);
	}
	
	@GetMapping("/Cliente")
	public ResponseDTO<List<Cliente>> obtenerCliente(){
		return clienteController.findAll();
	}
	
	@GetMapping("/Cliente/{id}")
	public ResponseDTO<Cliente> obtenerClientePorId(@PathVariable(value ="id") long id){
		return clienteController.findById(id);
	}
	
	@PutMapping("/Cliente/{id}")
	public ResponseDTO<Cliente> modificarCliente(@PathVariable(value ="id") long id, @RequestBody Cliente cliente) {
		return clienteController.update(id, cliente);					
	}
}
