package com.facturaproducto.app.domain.service;

import java.util.List;
import java.util.Optional;

import com.facturaproducto.app.domain.models.Factura;
import com.facturaproducto.app.shared.domain.Codigo;

public interface FacturaService {
	
	
	public List<Factura> findByIds(List<Codigo> codigos);

	public List<Factura> findAll();

	public void save(Factura factura);

	public void deleteById(Codigo codigo);

	public Optional<Factura> findById(Codigo codigo);

}
