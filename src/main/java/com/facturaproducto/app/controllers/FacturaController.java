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

import com.facturaproducto.app.application.FacturaApplication;
import com.facturaproducto.app.domain.service.FacturaService;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.FacturaMapper;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.FacturaRestDto;

@RestController
@RequestMapping("/Factura")
public class FacturaController {

	private FacturaApplication facturaAplication;

	public FacturaController(@Autowired FacturaMapper facturaMapper, @Autowired FacturaService facturaService,
			@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.facturaAplication = new FacturaApplication(facturaMapper, facturaService, productoService, productoMapper);
	}

	@PostMapping
	public void crear(@RequestBody FacturaRestDto factura) {
		facturaAplication.crear(factura);
	}

	@GetMapping("/{codigo}")
	public FacturaRestDto buscar(@PathVariable String codigo) {
		return facturaAplication.buscar(codigo);
	}

	@GetMapping
	public List<FacturaRestDto> listarFacturas() {
		return facturaAplication.listarFacturas();
	}

	@DeleteMapping("/{codigo}")
	void eliminar(@PathVariable String codigo) {
		facturaAplication.eliminar(codigo);
	}

	@PutMapping()
	void actualizar(@RequestBody FacturaRestDto facturaA) {
		facturaAplication.actualizar(facturaA);
	}

}
