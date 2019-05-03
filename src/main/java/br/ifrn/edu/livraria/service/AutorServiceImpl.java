package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.AutorDao;
import br.ifrn.edu.livraria.domain.Autor;

@Service @Transactional(readOnly = false)
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	private AutorDao dao;

	@Override
	public void salvar(Autor autor) {
		dao.save(autor);
		
	}

	@Override
	public void editar(Autor autor) {
		dao.update(autor);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);	
		
	}

	@Override
	public Autor buscarPorId(Long id) {
		return dao.findById(id); 
	}

	@Override
	public List<Autor> buscarTodos() {
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
	public boolean autorTemLivros(Long id) {
		// TODO Auto-generated method stub
		return false;
	} 

}
