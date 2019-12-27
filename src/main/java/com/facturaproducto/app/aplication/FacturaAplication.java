package com.facturaproducto.app.aplication;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import com.facturaproducto.app.domain.service.FacturaService;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.FacturaMapper;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.FacturaRestDto;
import com.facturaproducto.app.infraestructura.restdto.ItemRestDto;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;

public class FacturaAplication {
	
	private FacturaMapper facturaMapper;

	private FacturaService facturaService;
	
	private ProductoService productoService;
	
	private ProductoMapper productoMapper;
	
	public FacturaAplication(FacturaMapper facturaMapper, FacturaService facturaService,
			ProductoService productoService, ProductoMapper productoMapper) {
		this.facturaMapper = facturaMapper;
		this.facturaService = facturaService;
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}
	
	
	public void addFactura(FacturaRestDto factura) {
		FacturaRestDto factu = factura;
		factu.setCodigo(UUID.randomUUID().toString());
		factu.setItems(this.cargarItems(factu.getItems()));
		factu.setValorTotal(this.calcularFactura(factu.getItems()));

		facturaService.save(facturaMapper.apiConvertirDominioaDto(factu));
		
	}
	
	
	
	public List<ItemRestDto> cargarItems(List<ItemRestDto> items) {
		for (ItemRestDto i : items) {
			i.setCodigo(UUID.randomUUID().toString());
			i.setProducto(this.cargarProducto(i.getProducto()));
			i.setValorTotal(i.getCantidad() * i.getProducto().getValor());
		}

		return items;
	}
	
	
	public ProductoRestDto cargarProducto(ProductoRestDto producto) {
		return productoMapper.apiConvertirDominioaDto(productoService.buscarUno(producto.getCodigo()));
	}
	
	public Double calcularFactura(List<ItemRestDto> item) {
		double total = 0.0;
		for (ItemRestDto i : item) {
			total = total + (i.getCantidad() * i.getProducto().getValor());
		}
		return total;
	}

}
