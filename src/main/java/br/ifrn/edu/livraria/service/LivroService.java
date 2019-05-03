package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Livro;

public interface LivroService {
	
	void salvar(Livro livro);

    void editar(Livro livro);

    void excluir(Long id);

    Livro buscarPorId(Long id);

    List<Livro> buscarTodos();

	List<Livro> buscarPorTitulo(String titulo);

	List<Livro> buscarPorAutor(Long id);

}
