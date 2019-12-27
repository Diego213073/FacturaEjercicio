package com.facturaproducto.app.infraestrutura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturaproducto.app.infraestructura.dto.ProductoDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoDto, String>{


}
