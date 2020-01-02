package com.facturaproducto.app.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.facturaproducto.app.domain.models.Factura;
import com.facturaproducto.app.domain.service.FacturaService;
import com.facturaproducto.app.domain.service.ProductoService;
import com.facturaproducto.app.exceptions.ProductoNoEncontradoException;
import com.facturaproducto.app.exceptions.RegistroNoEncontradoException;
import com.facturaproducto.app.infraestructura.mapper.FacturaMapper;
import com.facturaproducto.app.infraestructura.mapper.ProductoMapper;
import com.facturaproducto.app.infraestructura.restdto.FacturaRestDto;
import com.facturaproducto.app.infraestructura.restdto.ProductoRestDto;
import com.facturaproducto.app.shared.domain.Codigo;

public class FacturaApplication {

	private FacturaMapper facturaMapper;

	private FacturaService facturaService;

	private ProductoService productoService;

	private ProductoMapper productoMapper;

	public FacturaApplication(FacturaMapper facturaMapper, FacturaService facturaService,
			ProductoService productoService, ProductoMapper productoMapper) {
		this.facturaMapper = facturaMapper;
		this.facturaService = facturaService;
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	private static final Logger LOG = Logger.getLogger(FacturaApplication.class.getName());

	public void crear(FacturaRestDto factura) {
		Double valorTotalFactura = this.calcularValorFactura(factura);
		if (!Optional.ofNullable(factura.getCodigo()).isPresent()) {
			factura.setCodigo(UUID.randomUUID().toString());
		}
		factura.getItems().stream().forEach(item -> item.setCodigo(UUID.randomUUID().toString()));
		if (valorTotalFactura.equals(factura.getValorTotal())) {
			facturaService.save(facturaMapper.apiConvertirDtoParaDominio(factura));
			LOG.severe(" guardó");
		}
		LOG.severe("No guardó");

	}

	public Double calcularValorFactura(FacturaRestDto factura) {
		List<ProductoRestDto> productos = cargarProductos(
				factura.getItems().stream().map(item -> item.getProducto().getCodigo()).collect(Collectors.toList()));
		factura.getItems().stream().forEach(item -> {
			item.setProducto(this.getProducto(item.getProducto().getCodigo(), productos));
			item.setValorTotal(item.getProducto().getValor() * item.getCantidad());
		});
		return factura.getItems().stream().map(item -> item.getValorTotal()).reduce((valor1, valor2) -> valor1 + valor2)
				.get();
	}

	public ProductoRestDto getProducto(String codigo, List<ProductoRestDto> productos) {
		return productos.stream().filter(p -> p.getCodigo().matches(codigo)).findAny()
				.orElseThrow(() -> new ProductoNoEncontradoException());
	}

	public List<ProductoRestDto> cargarProductos(List<String> codigos) {

		return productoMapper.apitransformarListDominioParaDto(productoService
				.findByIds(codigos.stream().map(codigo -> new Codigo(codigo)).collect(Collectors.toList())));
	}

	public FacturaRestDto buscar(String codigo) {
		return facturaMapper.apiConvertirDominioParaDto(
				facturaService.findById(new Codigo(codigo)).orElseThrow(() -> new RegistroNoEncontradoException()));
	}

	public List<FacturaRestDto> listarFacturas() {
		List<Factura> dom = facturaService.findAll();

		return facturaMapper.apitransformarListDominioParaDto(dom);
	}

	public void eliminar(String codigo) {
		facturaService.findById(new Codigo(codigo)).orElseThrow(() -> new RegistroNoEncontradoException()).getCodigo();
		facturaService.deleteById(new Codigo(codigo));
	}

	public void actualizar(FacturaRestDto facturaA) {
		if (facturaService.findById(new Codigo(facturaA.getCodigo()))
				.orElseThrow(() -> new RegistroNoEncontradoException()) != null) {
			facturaService.save(facturaMapper.apiConvertirDtoParaDominio(facturaA));
		}
	}
}
