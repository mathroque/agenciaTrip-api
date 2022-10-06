package com.api.agenciaTrip.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.agenciaTrip.models.ClienteModel;
import com.api.agenciaTrip.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public boolean existsByEmail(String email) {
		return clienteRepository.existsByEmail(email);
	}

	@Transactional
	public ClienteModel save(ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}

	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<ClienteModel> findById(UUID id) {
		return clienteRepository.findById(id);
	}
	
	@Transactional
	public void delete(ClienteModel clienteModel) {
		clienteRepository.delete(clienteModel);
	}

}
