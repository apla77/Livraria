package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Usuario;

public interface UsuarioService {

	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario buscarPorId(Long id);
	
	List<Usuario>buscarTodos();
	
	List<Usuario> buscarPorNome(String nome);
	
	//boolean usuarioTemPedidos(Long id);
}
