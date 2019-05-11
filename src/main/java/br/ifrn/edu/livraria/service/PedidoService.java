package br.ifrn.edu.livraria.service;

import java.util.List;

import br.ifrn.edu.livraria.domain.Pedido;

public interface PedidoService {
	
	
	void salvar(Pedido pedido);
	
	void editar(Pedido pedido);
	
	void excluir(Long id);
	
	Pedido buscarPorId(Long id);
	
	List<Pedido> buscarTodos();
	
	boolean pedidoTemLivros(Long id);


}
