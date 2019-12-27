package com.facturaproducto.app.aplication;

import java.util.List;
import java.util.UUID;

import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;

public class ProductoAplication {

	private ProductoService productoService;
	private ProductoMapper productoMapper;

	public ProductoAplication(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public void crear(ProductoRestDto p) {
		if (p.getCodigo() == null) {
			p.setCodigo(UUID.randomUUID().toString());
		}
		productoService.guardar(productoMapper.apiConvertirDtoaDominio(p));
	}


	public ProductoRestDto findbyid(String codigo) {
		return productoMapper.apiConvertirDominioaDto(productoService.buscarUno(codigo));
	}


	public List<ProductoRestDto> findProductos() {
		return productoMapper.apiconvertirDominioaDto(productoService.findAll());
	}


	public void delete(String codigo) {
		productoService.eliminar(codigo);
	}

	// Actualizar
	public void update(ProductoRestDto cancionRestDto) {
		productoService.editar(productoMapper.apiConvertirDtoaDominio(cancionRestDto));
	}

}
