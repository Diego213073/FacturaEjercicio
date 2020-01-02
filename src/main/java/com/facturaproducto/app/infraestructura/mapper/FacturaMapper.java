package com.facturaproducto.app.infraestructura.mapper;


import java.util.Optional;

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
	public FacturaDto transformarDominioParaDto(Factura factura) {
		FacturaDto facturaDto = new FacturaDto();
		facturaDto.setCodigo(factura.getCodigo().getValue());
		facturaDto.setNombreCliente(factura.getNombreCliente().getValue());
		facturaDto.setValorTotal(factura.getValorTotal().getValue());
		facturaDto.setItems(itemMapper.transformarListDominioParaDto(factura.getItems()));
		return facturaDto;
	}

	@Override
	public Factura transformarDtoParaDominio(FacturaDto facturaDto) {
		return Factura.of(new Codigo(facturaDto.getCodigo()), new ValorTotal(facturaDto.getValorTotal()),
				new Nombre(facturaDto.getNombreCliente()),
				itemMapper.transformarListaDtoParaDominio(facturaDto.getItems()));
	}

	@Override
	public Optional<Factura> transformarDtoParaDominio(Optional<FacturaDto> i) {
		if (!i.isPresent())
			return Optional.empty();

		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<FacturaDto> transformarDominioParaDto(Optional<Factura> o) {
		if (!o.isPresent())
			return Optional.empty();

		return Optional.of(this.transformarDominioParaDto(o.get()));
	}

	@Override
	public FacturaRestDto apiConvertirDominioParaDto(Factura o) {
		FacturaRestDto facturaRest = new FacturaRestDto();
		facturaRest.setCodigo(o.getCodigo().getValue());
		facturaRest.setNombreCliente(o.getNombreCliente().getValue());
		facturaRest.setValorTotal(o.getValorTotal().getValue());
		facturaRest.setItems(itemMapper.apitransformarListDominioParaDto(o.getItems()));

		return facturaRest;
	}

	@Override
	public Factura apiConvertirDtoParaDominio(FacturaRestDto i) {

		return Factura.of(new Codigo(i.getCodigo()), new ValorTotal(i.getValorTotal()),
				new Nombre(i.getNombreCliente()), itemMapper.apitransformarListaDtoParaDominio(i.getItems()));

	}
	
	
	

}
