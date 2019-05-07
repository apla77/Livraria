package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Categoria;
import br.ifrn.edu.livraria.service.CategoriaService;

@Component
public class StringToCategoriaConverter implements Converter<String, Categoria>{

	@Autowired
	private CategoriaService service;

	@Override
	public Categoria convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
