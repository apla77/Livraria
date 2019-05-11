package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Pedido;

public interface PedidoDao {
	
	void save(Pedido pedido);

    void update(Pedido pedido);

    void delete(Long id);

    Pedido findById(Long id);

    List<Pedido> findAll();

}
