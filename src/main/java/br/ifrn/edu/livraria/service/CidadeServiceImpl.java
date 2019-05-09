package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.CidadeDao;
import br.ifrn.edu.livraria.domain.Cidade;

@Service
@Transactional(readOnly = true)
public class CidadeServiceImpl implements CidadeService{
	
	@Autowired
	private CidadeDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Cidade cidade) {
		dao.save(cidade);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Cidade cidade) {
		dao.update(cidade);
		
	}
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Cidade> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Cidade> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Override
	public boolean cidadeTemUsuarios(Long id) {
		if (buscarPorId(id).getNome().isEmpty()) {
			return false;
		}
		return true;
	}

}
