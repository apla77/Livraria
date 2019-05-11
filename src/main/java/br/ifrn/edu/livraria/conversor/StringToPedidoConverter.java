package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Pedido;
import br.ifrn.edu.livraria.service.PedidoService;

@Component
public class StringToPedidoConverter implements Converter<String, Pedido>{

	@Autowired
	private PedidoService service;

	@Override
	public Pedido convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
