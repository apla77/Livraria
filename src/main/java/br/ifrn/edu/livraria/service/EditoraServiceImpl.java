package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifrn.edu.livraria.dao.EditoraDao;
import br.ifrn.edu.livraria.domain.Editora;

@Service @Transactional(readOnly = false)
public class EditoraServiceImpl implements EditoraService{

	@Autowired
	private EditoraDao dao;
	
	@Override
	public void salvar(Editora editora) {
		dao.save(editora);
		
	}

	@Override
	public void editar(Editora editora) {
		dao.update(editora);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Editora buscarPorId(Long id) {
		return dao.findById(id); 
	}

	@Override
	public List<Editora> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean editoraTemLivros(Long id) {
		if (buscarPorId(id).getLivros().isEmpty()) {
			return false;
		}
		return true;
	}

}
