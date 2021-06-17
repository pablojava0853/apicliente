package com.brq.cliente.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brq.cliente.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.brq.cliente.models.Cliente;
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Clientes")
@CrossOrigin(origins = "*")
public class ClienteResource {
	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	@ApiOperation(value="Retorna uma lista de clientes")
	public List<Cliente>listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value = "Retorna um cliente por ID")
	public Cliente listaClienteUnico(@PathVariable(value="id") long id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Salva um cliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/cliente")
	@ApiOperation(value="Deleta um cliente ")
	public void deletarCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@PutMapping("/cliente")
	@ApiOperation(value="Atualiza um cliente")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
