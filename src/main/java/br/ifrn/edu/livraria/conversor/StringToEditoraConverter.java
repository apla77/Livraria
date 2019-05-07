package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Editora;
import br.ifrn.edu.livraria.service.EditoraService;

@Component
public class StringToEditoraConverter implements Converter<String, Editora>{

	@Autowired
	private EditoraService service;

	@Override
	public Editora convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
