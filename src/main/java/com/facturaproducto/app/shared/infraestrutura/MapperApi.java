package com.facturaproducto.app.shared.infraestrutura;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApi<I, O> {

	public I apiConvertirDtoaDominio(O o);
	
	public O apiConvertirDominioaDto(I i);
	
	public default List<I>  apiconvertirDtoaDominio(List <O> o){
		return o.stream().map(valor -> apiConvertirDtoaDominio(valor)).collect(Collectors.toList());  
	}

	public default List<O>  apiconvertirDominioaDto(List <I> i){
		return i.stream().map(valor -> apiConvertirDominioaDto(valor)).collect(Collectors.toList());
	}
}
