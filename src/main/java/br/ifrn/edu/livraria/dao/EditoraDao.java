package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Editora;

public interface EditoraDao {
	
	void save(Editora editora);

    void update(Editora editora);

    void delete(Long id);

    Editora findById(Long id);

    List<Editora> findAll();
}
