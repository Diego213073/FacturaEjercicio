package com.facturaproducto.app.infraestrutura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturaproducto.app.infraestructura.dto.ItemDto;

public interface ItemRepository extends JpaRepository<ItemDto, String>{

}
