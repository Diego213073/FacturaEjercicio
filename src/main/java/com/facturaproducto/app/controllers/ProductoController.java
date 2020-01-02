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

import com.facturaproducto.app.application.ProductoApplication;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
	
	private ProductoApplication productoAplication;

	public ProductoController(@Autowired ProductoService productoService, ProductoMapper productoMapper) {
		this.productoAplication = new ProductoApplication(productoService, productoMapper);
	}
	
	
	//Listar todos los prodcutos:funcional
	@GetMapping
	public List<ProductoRestDto> listarProductos() {
		return productoAplication.findProductos();
	}
	
	//Crear un nuevo producto: funcional
	@PostMapping
	public void crear(@RequestBody ProductoRestDto producto) {
		productoAplication.save(producto);
	}
	
	
	//Buscar un producto mediante el código:funcional
	@GetMapping("/{codigo}")
	public ProductoRestDto buscar(@PathVariable String codigo) {
		return productoAplication.findById(codigo);

	}
	


	//Editar un producto:Funcional
	@PutMapping()
	void actualizar(@RequestBody ProductoRestDto productoA) {
		productoAplication.update(productoA);
	}
	
	//Eliminar un producto:funcional
	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		productoAplication.delete(codigo);
	}

}
