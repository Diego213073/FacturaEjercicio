package com.facturaproducto.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Producto;
import com.facturaproducto.app.shared.domain.Codigo;

@Component
public interface ProductoService {

	public List<Producto> findByIds(List<Codigo> codigos);

	public List<Producto> findAll();

	public void save(Producto producto);

	public void deleteById(Codigo codigo);

	public Optional<Producto> findById(Codigo codigo);

}
