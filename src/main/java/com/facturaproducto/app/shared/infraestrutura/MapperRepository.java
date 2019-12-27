package com.facturaproducto.app.shared.infraestrutura;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperRepository<I, O> {

	public I convertirDtoaDominio(O o);

	public O convertirDominioaDto(I i);
	

	public default List<I> convertirDtoaDominio(List<O> o) {
		return o.stream().map(valor -> convertirDtoaDominio(valor)).collect(Collectors.toList());
	}

	public default List<O> convertirDominioaDto(List<I> i) {
		return i.stream().map(valor -> convertirDominioaDto(valor)).collect(Collectors.toList());
	}

}
