package com.facturaproducto.app.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.exceptions.RegistroNoEncontradoException;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;
import com.facturaproducto.app.shared.domain.Codigo;

public class ProductoApplication {

	private ProductoService productoService;
	private ProductoMapper productoMapper;

	
	public ProductoApplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public void save(ProductoRestDto producto) {

		if (!Optional.ofNullable(producto.getCodigo()).isPresent()) {
			producto.setCodigo(UUID.randomUUID().toString());
		}
		productoService.save(productoMapper.apiConvertirDtoParaDominio(producto));
	}

	public ProductoRestDto findById(String codigo) {
		return productoMapper.apiConvertirDominioParaDto(productoService.findById(new Codigo(codigo)).get());
	}

	public List<ProductoRestDto> findProductos() {
		return productoMapper.apitransformarListDominioParaDto(productoService.findAll());
	}

	public void delete(String codigo) {
		productoService.deleteById(productoService.findById(new Codigo(codigo))
				.orElseThrow(() -> new RegistroNoEncontradoException()).getCodigo());
	}

	public void update(ProductoRestDto productoA) {
		if (productoService.findById(new Codigo(productoA.getCodigo()))
				.orElseThrow(() -> new RegistroNoEncontradoException()) != null) {
			productoService.save(productoMapper.apiConvertirDtoParaDominio(productoA));
		}
	}
}
