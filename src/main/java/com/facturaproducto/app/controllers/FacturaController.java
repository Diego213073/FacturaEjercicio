package com.facturaproducto.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturaproducto.app.aplication.FacturaAplication;
import com.facturaproducto.app.domain.service.FacturaService;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.mapper.FacturaMapper;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestrutura.repository.database.FacturaRepository;


@RestController
@RequestMapping("/factura")
public class FacturaController {

	FacturaAplication facturaAplication;
//	
//	public FacturaController(@Autowired FacturaRepository facturaRepository, @Autowired FacturaService facturaService,
//			@Autowired FacturaMapper facturaMapper, @Autowired ProductoService productoService,
//			@Autowired ProductoMapper productoMapper) {
//		this.facturaAplication = new FacturaAplication(facturaRepository,facturaService,facturaMapper,productoService);
//	}
	

}
