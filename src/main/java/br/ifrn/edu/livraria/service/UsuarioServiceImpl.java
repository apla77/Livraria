package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.UsuarioDao;
import br.ifrn.edu.livraria.domain.Usuario;

@Service @Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

	/*
	@Override
	public boolean usuarioTemPedidos(Long id) {
		if (buscarPorId(id).getPedidos().isEmpty()) {
			return false;
		}
		return true;
	}
    */
	@Override
	public List<Usuario> buscarPorNome(String nome) {

		return dao.findByNome(nome);
	}

	@Override
	public boolean usuarioTemPedidos(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
