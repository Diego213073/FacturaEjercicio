package com.facturaproducto.app.infraestructura.mapper;

import java.util.Optional;

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
public class ProductoMapper implements MapperRepository<ProductoDto, Producto>, MapperApi<ProductoRestDto, Producto> {

	/*Recibe datos de las clases pertenecientes al dominio
	para insertarlos en las clases pertenecientes a Dto.
	*/
	@Override
	public ProductoDto transformarDominioParaDto(Producto producto) {
		ProductoDto productoDto = new ProductoDto();
		productoDto.setCodigo(producto.getCodigo().getValue());
		productoDto.setNombre(producto.getNombre().getValue());
		productoDto.setValor(producto.getValor().getValue());
		return productoDto;
	}

	
	/*Recibe datos de las clases pertenecientes a Dto
	para insertarlos en las clases pertenecientes a dominio.
	*/
	@Override
	public Producto transformarDtoParaDominio(ProductoDto productoDto) {
		return Producto.of(new Codigo(productoDto.getCodigo()), new Nombre(productoDto.getNombre()),
				new Valor(productoDto.getValor()));
	}
	

	@Override
	public Optional<Producto> transformarDtoParaDominio(Optional<ProductoDto> i) {
		if (!i.isPresent())//Si no está presente entra en la condición
			return Optional.empty();//Optional para evitar exceptiones, con Empty se revisa si hay excepciones

		return Optional.of(this.transformarDtoParaDominio(i.get()));
	}

	@Override
	public Optional<ProductoDto> transformarDominioParaDto(Optional<Producto> o) {
		if (!o.isPresent())
			return Optional.empty();

		return Optional.of(this.transformarDominioParaDto(o.get()));
	}

	@Override
	public ProductoRestDto apiConvertirDominioParaDto(Producto o) {
		return new ProductoRestDto(o.getCodigo().getValue(), o.getNombre().getValue(), o.getValor().getValue());
	}

	@Override
	public Producto apiConvertirDtoParaDominio(ProductoRestDto i) {
		return Producto.of(new Codigo(i.getCodigo()), new Nombre(i.getNombre()), new Valor(i.getValor()));
	}

}
