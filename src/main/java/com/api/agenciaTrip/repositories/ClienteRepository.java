package com.api.agenciaTrip.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agenciaTrip.models.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

	boolean existsByEmail(String email);

}
