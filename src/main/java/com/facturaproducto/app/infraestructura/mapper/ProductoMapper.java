package com.facturaproducto.app.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Producto;
import com.facturaproducto.app.infraestructura.dto.ProductoDto;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;
import com.facturaproducto.app.shared.domain.Codigo;
import com.facturaproducto.app.shared.domain.Nombre;
import com.facturaproducto.app.shared.domain.Valor;
import com.facturaproducto.app.shared.infraestrutura.MapperApi;
import com.facturaproducto.app.shared.infraestrutura.MapperRepository;


@Component
public class ProductoMapper
implements MapperRepository<Producto, ProductoDto>, MapperApi<Producto, ProductoRestDto> {

	@Override
	public Producto apiConvertirDtoaDominio(ProductoRestDto o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoRestDto apiConvertirDominioaDto(Producto i) {
		return new ProductoRestDto(i.getCodigo().getValue(), i.getNombre().getValue(), i.getValor().getValue());
	}

	@Override
	public Producto convertirDtoaDominio(ProductoDto o) {
		return Producto.of(new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	}

	@Override
	public ProductoDto convertirDominioaDto(Producto i) {
		return new ProductoDto(i.getCodigo().getValue(), i.getNombre().getValue(), i.getValor().getValue());
	}

}
