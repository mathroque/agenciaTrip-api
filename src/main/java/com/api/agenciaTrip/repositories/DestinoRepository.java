package com.api.agenciaTrip.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.agenciaTrip.models.DestinoModel;

public interface DestinoRepository extends JpaRepository<DestinoModel, UUID> {

}
