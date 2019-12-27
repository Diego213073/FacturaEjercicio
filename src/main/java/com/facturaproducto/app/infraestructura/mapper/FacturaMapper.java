package com.facturaproducto.app.infraestructura.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Factura;
import com.facturaproducto.app.infraestructura.dto.FacturaDto;
import com.facturaproducto.app.infraestructura.restdto.FacturaRestDto;
import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.ValorTotal;
import com.facturaproducto.app.shared.infraestrutura.MapperApi;
import com.facturaproducto.app.shared.infraestrutura.MapperRepository;

@Component
public class FacturaMapper implements MapperRepository<FacturaDto, Factura>, MapperApi<FacturaRestDto, Factura>{

	
	@Autowired
	ItemMapper itemMapper;

	@Override
	public FacturaRestDto apiConvertirDtoaDominio(Factura o) {
		FacturaRestDto facturaRest = new FacturaRestDto();
		facturaRest.setCodigo(o.getCodigo().getValue());
		facturaRest.setNombreCliente(o.getNombreCliente().getValue());
		facturaRest.setValorTotal(o.getValorTotal().getValue());
		facturaRest.setItems(itemMapper.apiconvertirDtoaDominio(o.getItems()));
		return facturaRest;
	}

	@Override
	public Factura apiConvertirDominioaDto(FacturaRestDto i) {
		return Factura.of(new Codigo(i.getCodigo()), new ValorTotal(i.getValorTotal()),
				new Nombre(i.getNombreCliente()), itemMapper.apiconvertirDominioaDto(i.getItems()));
	}

	@Override
	public FacturaDto convertirDtoaDominio(Factura o) {
		FacturaDto facturaDto = new FacturaDto();
		facturaDto.setCodigo(o.getCodigo().getValue());
		facturaDto.setNombreCliente(o.getNombreCliente().getValue());
		facturaDto.setValorTotal(o.getValorTotal().getValue());
		facturaDto.setItems(itemMapper.convertirDtoaDominio(o.getItems()));
		return facturaDto;
	}

	@Override
	public Factura convertirDominioaDto(FacturaDto i) {
		return Factura.of(new Codigo(i.getCodigo()), new ValorTotal(i.getValorTotal()),
				new Nombre(i.getNombreCliente()),
				itemMapper.convertirDominioaDto(i.getItems()));
	}
	
	
	
	

}
