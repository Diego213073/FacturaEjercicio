package com.facturaproducto.app.shared.infraestrutura;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface MapperRepository<Dto, Dominio> {

	public Dto transformarDominioParaDto(Dominio o);//

	public Dominio transformarDtoParaDominio(Dto i);

	public Optional<Dominio> transformarDtoParaDominio(Optional<Dto> i);

	public Optional<Dto> transformarDominioParaDto(Optional<Dominio> o);

	public default List<Dominio> transformarListaDtoParaDominio(List<Dto> instancias) {
		return instancias.stream().map(i -> transformarDtoParaDominio(i)).collect(Collectors.toList());
	}

	public default List<Dto> transformarListDominioParaDto(List<Dominio> instancias) {
		return instancias.stream().map(o -> transformarDominioParaDto(o)).collect(Collectors.toList());
	}

}
