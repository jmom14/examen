package com.example.demo.controller;

import com.example.demo.repository.ClienteRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entities.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRespository clienteRepository;
	
	public ResponseDTO<Cliente> create(Cliente cliente) {
		ResponseDTO<Cliente> response = new ResponseDTO<Cliente>();
		
		try {			
			cliente.setFechaActualizacion(new Date());
			cliente.setFechaCreacion(new Date());
			Cliente nuevoCliente = clienteRepository.save(cliente);	
			response.setData(nuevoCliente);
			response.setCve_Error(0);
			return response;
		} catch (Exception e){
			response.setCve_Error(-1);
			response.setCve_message(e.getMessage());
			response.setData(null);
			return response;
		}
	}
	
	public ResponseDTO<List<Cliente>> findAll() {
		ResponseDTO<List<Cliente>> response = new ResponseDTO<>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clienteRepository.findAll().forEach(clientes::add);
		response.setData(clientes);
		response.setCve_Error(0);
		return response;
	}
	
	public ResponseDTO<Cliente> findById(long id) {
		ResponseDTO<Cliente> response = new ResponseDTO<>();
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			response.setData(cliente.get());
			response.setCve_Error(0);
			return response;
		}
		response.setCve_Error(-1);
		response.setCve_message("NOT FOUND");
		return response;
	}
	
	public ResponseDTO<Cliente> update(long id, Cliente cliente) {
		ResponseDTO<Cliente> response = new ResponseDTO<>();
		Optional<Cliente> clienteToUpdate = clienteRepository.findById(id);
		
		if(clienteToUpdate.isPresent()) {
			Cliente c = clienteToUpdate.get();
			c.setPeso(cliente.getPeso());
			c.setEstatura(cliente.getEstatura());
			c.setFechaActualizacion(new Date());
			Cliente clienteActualizado = clienteRepository.save(c);
			response.setData(clienteActualizado);
			response.setCve_Error(0);
			return response;
		}
		response.setCve_Error(-1);
		response.setCve_message("NOT FOUND");
		return response;
	}

}
