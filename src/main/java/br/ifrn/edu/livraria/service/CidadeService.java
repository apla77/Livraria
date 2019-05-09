package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Cidade;

public interface CidadeService {

	void salvar(Cidade cidade);

    void editar(Cidade cidade);

    void excluir(Long id);

    Cidade buscarPorId(Long id);

    List<Cidade> buscarTodos();

	List<Cidade> buscarPorNome(String nome);

	boolean cidadeTemUsuarios(Long id);

}
