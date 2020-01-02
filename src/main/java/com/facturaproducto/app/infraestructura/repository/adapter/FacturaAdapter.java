package com.facturaproducto.app.infraestructura.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturaproducto.app.domain.models.Factura;
import com.facturaproducto.app.domain.service.FacturaService;
import com.facturaproducto.app.infraestructura.mapper.FacturaMapper;
import com.facturaproducto.app.infraestrutura.repository.database.FacturaRepository;
import com.facturaproducto.app.shared.domain.Codigo;

@Service
public class FacturaAdapter implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	FacturaMapper facturaMapper;

	@Override
	public List<Factura> findByIds(List<Codigo> codigos) {
		// TODO Auto-generated method stub
		return facturaMapper.transformarListaDtoParaDominio(facturaRepository
				.findAllById(codigos.stream().map(codigo -> codigo.getValue()).collect(Collectors.toList())));
	}

	@Override
	public List<Factura> findAll() {
		return facturaMapper.transformarListaDtoParaDominio(facturaRepository.findAll());
	}

	@Override
	public void save(Factura factura) {
		facturaRepository.save(facturaMapper.transformarDominioParaDto(factura));
	}

	@Override
	public void deleteById(Codigo codigo) {
		facturaRepository.deleteById(codigo.getValue());

	}

	@Override
	public Optional<Factura> findById(Codigo codigo) {
		return facturaMapper.transformarDtoParaDominio(facturaRepository.findById(codigo.getValue()));
	}
}
