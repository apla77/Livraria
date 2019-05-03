package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Autor;

public interface AutorService { 
	
	void salvar(Autor autor);
	
	void editar(Autor autor);
	
	void excluir(Long id);
	
	Autor buscarPorId(Long id);
	
	List<Autor> buscarTodos();
	
	boolean autorTemLivros(Long id);
}
