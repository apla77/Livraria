package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Autor;
import br.ifrn.edu.livraria.service.AutorService;

@Component
public class StringToAutorConverter implements Converter<String, Autor>{

	@Autowired
	private AutorService service;

	@Override
	public Autor convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
