package com.facturaproducto.app.infraestructura.repository.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturaproducto.app.domain.models.Producto;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.exceptions.RegistroNoEncontradoException;
import com.facturaproducto.app.infraestructura.dto.ProductoDto;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestrutura.repository.database.ProductoRepository;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Producto> findAll() {

		return productoRepository.findAll().stream().map(producto -> productoMapper.convertirDtoaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.convertirDominioaDto(producto));

	}

	@Override
	public void editar(Producto producto) {
		this.buscarUno(producto.getCodigo().getValue());
		productoRepository.save(productoMapper.convertirDominioaDto(producto));

	}

	@Override
	public Producto buscarUno(String codigo) {
		return productoMapper.convertirDtoaDominio(
				productoRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoException()));
	}

	@Override
	public void eliminar(String codigo) {
		ProductoDto producto = productoRepository.findById(codigo)
				.orElseThrow(() -> new RegistroNoEncontradoException());
		productoRepository.deleteById(producto.getCodigo());

	}

	@Override
	public List<Producto> buscartodosIds(List<String> codigos) {
		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.convertirDtoaDominio(producto)).collect(Collectors.toList());

	}

}
