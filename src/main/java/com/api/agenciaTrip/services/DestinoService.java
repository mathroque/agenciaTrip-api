package com.api.agenciaTrip.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.agenciaTrip.models.DestinoModel;
import com.api.agenciaTrip.repositories.DestinoRepository;

@Service
public class DestinoService {
	
	final DestinoRepository destinoRepository;
	
	public DestinoService(DestinoRepository destinoRepository) {
		this.destinoRepository = destinoRepository;
	}

	@Transactional
	public DestinoModel save(DestinoModel destinoModel) {
		return destinoRepository.save(destinoModel);
	}

	public List<DestinoModel> findAll() {
		return destinoRepository.findAll();
	}

	public Optional<DestinoModel> findById(UUID id) {
		return destinoRepository.findById(id);
	}

	@Transactional
	public void delete(DestinoModel destinoModel) {
		destinoRepository.delete(destinoModel);		
	}

}
