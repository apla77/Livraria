package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Autor;

public interface AutorDao {
	
	void save(Autor autor);

    void update(Autor autor);

    void delete(Long id);

    Autor findById(Long id);

    List<Autor> findAll();
}
