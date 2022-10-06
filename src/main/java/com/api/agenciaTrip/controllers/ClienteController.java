package com.api.agenciaTrip.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.agenciaTrip.dtos.ClienteDto;
import com.api.agenciaTrip.models.ClienteModel;
import com.api.agenciaTrip.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {

	final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<Object> postCliente(@RequestBody @Valid ClienteDto clienteDto) {
		if (clienteService.existsByEmail(clienteDto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado.");
		}
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}

	@GetMapping
	public ResponseEntity<List<ClienteModel>> getAllClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") UUID id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		clienteService.delete(clienteModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ClienteDto clienteDto) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		clienteModel.setId(clienteModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
	}

}
