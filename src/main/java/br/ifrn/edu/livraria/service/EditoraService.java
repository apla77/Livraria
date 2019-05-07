package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Editora;

public interface EditoraService {
	
	void salvar(Editora editora);
	
	void editar(Editora editora);
	
	void excluir(Long id);
	
	Editora buscarPorId(Long id);
	
	List<Editora>buscarTodos();
	
	boolean editoraTemLivros(Long id);

}
