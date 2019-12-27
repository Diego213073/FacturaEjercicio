package com.facturaproducto.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturaproducto.app.aplication.ProductoAplication;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
	
	ProductoAplication productoAplication;

	public ProductoController(@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.productoAplication = new ProductoAplication(productoService, productoMapper);
	}
	
	
	//Listar todos los prodcutos:funcional
	@GetMapping
	public List<ProductoRestDto> getProductos() {
		return productoAplication.findProductos();
	}
	
	
	//Crear un nuevo producto: funcional
	@PostMapping
	public void save(@RequestBody ProductoRestDto producto) {
		productoAplication.crear(producto);
	}
	
	
	//Buscar un producto mediante el código:funcional
	@GetMapping("/{codigo}")
	public ProductoRestDto getProducto(@PathVariable String codigo) {
		return productoAplication.findbyid(codigo);
	}
	

	
	//Editar un producto:Funcional
	@PutMapping
	public void edit(@RequestBody ProductoRestDto producto) {
		productoAplication.update(producto);
	}

	
	//Eliminar un producto:funcional
	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable String codigo) {
		productoAplication.delete(codigo);
	}

}
