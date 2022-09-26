package com.api.agenciaTrip.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agenciaTrip.models.PromocaoModel;

public interface PromocaoRepository extends JpaRepository<PromocaoModel, UUID> {

	boolean existsByCidadeAndAno(String cidade, Integer ano);

}
