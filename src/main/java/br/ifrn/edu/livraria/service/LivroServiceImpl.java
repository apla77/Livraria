package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.LivroDao;
import br.ifrn.edu.livraria.domain.Livro;

@Service
@Transactional(readOnly = true)
public class LivroServiceImpl implements LivroService{

	@Autowired
	private LivroDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Livro livro) {
		dao.save(livro);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void editar(Livro livro) {
		dao.update(livro);
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Livro buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Livro> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		return dao.findByTitulo(titulo);
	}

	@Override
	public List<Livro> buscarPorAutor(Long id) {
		return dao.findByAutorId(id);
	}

}
