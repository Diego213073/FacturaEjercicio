package com.facturaproducto.app.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.facturaproducto.app.domain.models.Producto;

@Component
public interface ProductoService {

	public List<Producto> findAll();

	public void guardar(Producto producto);

	public void editar(Producto producto);

	public Producto buscarUno(String codigo);

	public void eliminar(String codigo);

	public List<Producto> buscartodosIds(List<String> codigos);

}
