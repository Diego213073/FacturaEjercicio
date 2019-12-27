package com.facturaproducto.app.infraestructura.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Item;
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
	ProductoMapper productoMapper;

	@Override
	public ItemRestDto apiConvertirDtoaDominio(Item o) {
		return new ItemRestDto(o.getCodigo().getValue(), o.getCantidad().getValue(), o.getValorTotal().getValue(),
				productoMapper.apiConvertirDominioaDto(o.getProducto()));
	}

	@Override
	public Item apiConvertirDominioaDto(ItemRestDto i) {
		return Item.of(new Codigo(i.getCodigo()), new Cantidad(i.getCantidad()), new ValorTotal(i.getValorTotal()),
				productoMapper.apiConvertirDtoaDominio(i.getProducto()));
	}

	@Override
	public ItemDto convertirDtoaDominio(Item o) {
		ItemDto itemDto = new ItemDto();
		itemDto.setCodigo(o.getCodigo().getValue());
		itemDto.setCantidad(o.getCantidad().getValue());
		itemDto.setProducto(productoMapper.convertirDominioaDto(o.getProducto()));
		return itemDto;
	}

	@Override
	public Item convertirDominioaDto(ItemDto i) {
		ValorTotal valorTotal = new ValorTotal(i.getCantidad() * i.getProducto().getValor());
		Codigo codigo = new Codigo(i.getCodigo());
		Cantidad cantidad = new Cantidad(i.getCantidad());

		return Item.of(codigo, cantidad, valorTotal, productoMapper.convertirDtoaDominio(i.getProducto()));
	}

}
