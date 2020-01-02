package com.facturaproducto.app.infraestructura.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Item;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.infraestructura.dto.ItemDto;
import com.facturaproducto.app.infraestructura.restdto.ItemRestDto;
import com.facturaproducto.app.shared.domain.Cantidad;
import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.ValorTotal;
import com.facturaproducto.app.shared.infraestrutura.MapperApi;
import com.facturaproducto.app.shared.infraestrutura.MapperRepository;

@Component
public class ItemMapper implements MapperRepository<ItemDto, Item>, MapperApi<ItemRestDto, Item> {

	@Autowired
	private ProductoMapper productoMapper;
	@Autowired
	ProductoService productoService;

	@Override
	public ItemRestDto apiConvertirDominioParaDto(Item o) {
		return new ItemRestDto(o.getCodigo().getValue(), o.getCantidad().getValue(), o.getValorTotal().getValue(),
				productoMapper.apiConvertirDominioParaDto(o.getProducto()));
	}

	@Override
	public Item apiConvertirDtoParaDominio(ItemRestDto i) {
		return Item.of(new Codigo(i.getCodigo()), new Cantidad(i.getCantidad()), new ValorTotal(i.getValorTotal()),
				productoMapper.apiConvertirDtoParaDominio(i.getProducto()));
	}

	@Override
	public ItemDto transformarDominioParaDto(Item o) {
		ItemDto oe = new ItemDto();
		oe.setCodigo(o.getCodigo().getValue());
		oe.setCantidad(o.getCantidad().getValue());
		oe.setProducto(productoMapper.transformarDominioParaDto(o.getProducto()));
		return oe;
	}

	@Override
	public Item transformarDtoParaDominio(ItemDto i) {
		ValorTotal valorTotal = new ValorTotal(i.getCantidad()*i.getProducto().getValor());
		Codigo codigo = new Codigo(i.getCodigo());
		Cantidad cantidad = new Cantidad(i.getCantidad());
		
	
		return Item.of(codigo, cantidad, valorTotal, productoMapper.transformarDtoParaDominio(i.getProducto()));
	}

	@Override
	public Optional<Item> transformarDtoParaDominio(Optional<ItemDto> i) {
		if (!i.isPresent())
			return Optional.empty();

		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<ItemDto> transformarDominioParaDto(Optional<Item> o) {
		if (!o.isPresent())
			return Optional.empty();

		return Optional.of(this.transformarDominioParaDto(o.get()));
	}


	
}
