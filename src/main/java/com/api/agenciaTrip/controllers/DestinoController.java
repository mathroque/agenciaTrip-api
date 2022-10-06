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

import com.api.agenciaTrip.dtos.DestinoDto;
import com.api.agenciaTrip.models.DestinoModel;
import com.api.agenciaTrip.services.DestinoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/destino")
public class DestinoController {

	final DestinoService destinoService;

	public DestinoController(DestinoService destinoService) {
		this.destinoService = destinoService;
	}

	@PostMapping
	public ResponseEntity<Object> postDestino(@RequestBody @Valid DestinoDto destinoDto) {
		var destinoModel = new DestinoModel();
		BeanUtils.copyProperties(destinoDto, destinoModel);
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.save(destinoModel));
	}

	@GetMapping
	public ResponseEntity<List<DestinoModel>> getAllDestinos() {
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDestino(@PathVariable(value = "id") UUID id) {
		Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
		if (!destinoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(destinoModelOptional.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDestino(@PathVariable(value = "id") UUID id) {
		Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
		if (!destinoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
		}
		destinoService.delete(destinoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Destino deletado.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDestino(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid DestinoDto destinoDto) {
		Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
		if (!destinoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
		}
		var destinoModel = new DestinoModel();
		BeanUtils.copyProperties(destinoDto, destinoModel);
		destinoModel.setId(destinoModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.save(destinoModel));
	}

}
