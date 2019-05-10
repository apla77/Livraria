package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Cidade;
import br.ifrn.edu.livraria.service.CidadeService;

@Component
public class StringToCidadeConverter implements Converter<String, Cidade>{

	@Autowired
	private CidadeService service;

	@Override
	public Cidade convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
