package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.PedidoDao;
import br.ifrn.edu.livraria.domain.Pedido;

@Service
@Transactional(readOnly = true)
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Pedido pedido) {
		dao.save(pedido);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Pedido pedido) {
		dao.update(pedido);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Pedido buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Pedido> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean pedidoTemLivros(Long id) {
		if (buscarPorId(id).getLivro().getTitulo().isEmpty()) {
			return false;
		}
		return true;
	}
}
