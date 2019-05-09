package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Livro;
import br.ifrn.edu.livraria.service.LivroService;

@Component
public class StringToLivroConverter implements Converter<String, Livro>{

	@Autowired
	private LivroService service;

	@Override
	public Livro convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
