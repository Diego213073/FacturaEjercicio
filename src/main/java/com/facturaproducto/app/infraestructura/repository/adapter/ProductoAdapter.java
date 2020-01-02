package com.facturaproducto.app.infraestructura.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturaproducto.app.domain.models.Producto;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestrutura.repository.database.ProductoRepository;
import com.facturaproducto.app.shared.domain.Codigo;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Producto> findByIds(List<Codigo> codigos) {
		// TODO Auto-generated method stub
		return productoRepository
				.findAllById(codigos.stream().map(codigo -> codigo.getValue()).collect(Collectors.toList())).stream()
				.map(producto -> productoMapper.transformarDtoParaDominio(producto)).collect(Collectors.toList());
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(productoMapper.transformarDominioParaDto(producto));
	}

	@Override
	public Optional<Producto> findById(Codigo codigo) {
		// TODO Auto-generated method stub
		return productoMapper.transformarDtoParaDominio(productoRepository.findById(codigo.getValue()));
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoMapper.transformarListaDtoParaDominio(productoRepository.findAll());
	}

	@Override
	public void deleteById(Codigo codigo) {
		productoRepository.deleteById(codigo.getValue());

	}


}
