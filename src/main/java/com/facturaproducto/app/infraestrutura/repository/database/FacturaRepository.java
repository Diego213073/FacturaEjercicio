package com.facturaproducto.app.infraestrutura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturaproducto.app.infraestructura.dto.FacturaDto;

public interface FacturaRepository extends JpaRepository<FacturaDto, String>{

}
