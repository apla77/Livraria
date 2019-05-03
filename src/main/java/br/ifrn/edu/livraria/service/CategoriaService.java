package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Categoria;


public interface CategoriaService {
	
	void salvar(Categoria categoria);
	
	void editar(Categoria categoria);
	
	void excluir(Long id);
	
	Categoria buscarPorId(Long id);
	
	List<Categoria> buscarTodos();
	
	boolean categoriaTemLivros(Long id);
}
