package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.CategoriaDao;
import br.ifrn.edu.livraria.domain.Categoria;


@Service @Transactional(readOnly = false)
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao dao;

	@Override
	public void salvar(Categoria categoria) {
		dao.save(categoria);		
	}

	@Override
	public void editar(Categoria categoria) {
		dao.update(categoria);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Categoria buscarPorId(Long id) {
		
		return dao.findById(id); 
	}

	@Override @Transactional(readOnly = true)
	public List<Categoria> buscarTodos() {
		
		return dao.findAll();
	}
/*
	@Override
	public boolean categoriaTemLivros(Long id) {
		if (buscarPorId(id).getLivros().isEmpty()) {
			return false;
		}
		return true;
	}
	*/

	@Override
	public boolean categoriaTemLivros(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
