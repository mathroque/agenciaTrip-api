package com.api.agenciaTrip.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.agenciaTrip.models.PromocaoModel;
import com.api.agenciaTrip.repositories.PromocaoRepository;

@Service
public class PromocaoService {

	final PromocaoRepository promocaoRepository;

	public PromocaoService(PromocaoRepository promocaoRepository) {
		this.promocaoRepository = promocaoRepository;
	}

	@Transactional
	public PromocaoModel save(PromocaoModel promocaoModel) {
		return promocaoRepository.save(promocaoModel);
	}

	public boolean existsByCidadeAndAno(String cidade, Integer ano) {
		return promocaoRepository.existsByCidadeAndAno(cidade, ano);
	}

	public List<PromocaoModel> findAll() {

		return promocaoRepository.findAll();
	}

	public Optional<PromocaoModel> findById(UUID id) {
		return promocaoRepository.findById(id);
	}

	@Transactional
	public void delete(PromocaoModel promocaoModel) {
		promocaoRepository.delete(promocaoModel);
	}

}
