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

import com.api.agenciaTrip.dtos.PromocaoDto;
import com.api.agenciaTrip.models.PromocaoModel;
import com.api.agenciaTrip.services.PromocaoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/promocao")
public class PromocaoController {

	final PromocaoService promocaoService;

	public PromocaoController(PromocaoService promocaoService) {
		this.promocaoService = promocaoService;
	}

	@PostMapping
	public ResponseEntity<Object> postPromocao(@RequestBody @Valid PromocaoDto promocaoDto) {
		if (promocaoService.existsByCidadeAndAno(promocaoDto.getCidade(), promocaoDto.getAno())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Já existe uma promoção registrada para este local no mesmo ano.");
		}
		var promocaoModel = new PromocaoModel();
		BeanUtils.copyProperties(promocaoDto, promocaoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(promocaoService.save(promocaoModel));
	}

	@GetMapping
	public ResponseEntity<List<PromocaoModel>> getAllPromocoes() {
		return ResponseEntity.status(HttpStatus.OK).body(promocaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOnePromocao(@PathVariable(value = "id") UUID id) {
		Optional<PromocaoModel> promocaoModelOptional = promocaoService.findById(id);
		if (!promocaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promoção não encontrada.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(promocaoModelOptional.get());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePromocao(@PathVariable(value = "id") UUID id) {
		Optional<PromocaoModel> promocaoModelOptional = promocaoService.findById(id);
		if (!promocaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promoção não encontrada.");
		}
		promocaoService.delete(promocaoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Promoção deletada.");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePromocao(@PathVariable(value = "id") UUID id, @RequestBody @Valid PromocaoDto promocaoDto) {
		Optional<PromocaoModel> promocaoModelOptional = promocaoService.findById(id);
		if (!promocaoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promocao não encontrada.");
		}
		var promocaoModel = new PromocaoModel();
		BeanUtils.copyProperties(promocaoDto, promocaoModel);
		promocaoModel.setId(promocaoModelOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(promocaoService.save(promocaoModel));
		}
	
	
	

}
