package br.ifrn.edu.livraria.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ifrn.edu.livraria.domain.Usuario;
import br.ifrn.edu.livraria.service.UsuarioService;

@Component
public class StringToUsuarioConverter implements Converter<String, Usuario>{

	@Autowired
	private UsuarioService service;

	@Override
	public Usuario convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
