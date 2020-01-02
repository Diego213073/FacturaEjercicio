package com.facturaproducto.app.shared.infraestrutura;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApi<RestDto, Dominio> {

	public RestDto apiConvertirDominioParaDto(Dominio o);

	public Dominio apiConvertirDtoParaDominio(RestDto i);
	
	public default List<Dominio> apitransformarListaDtoParaDominio(List<RestDto> instancias) {
		return instancias.stream().map(i -> apiConvertirDtoParaDominio(i)).collect(Collectors.toList());
	}

	public default List<RestDto> apitransformarListDominioParaDto(List<Dominio> instancias) {
		return instancias.stream().map(o -> apiConvertirDominioParaDto(o)).collect(Collectors.toList());
	}
}
