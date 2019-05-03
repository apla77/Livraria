package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Categoria;


public interface CategoriaDao {
	
	void save(Categoria categoria);

    void update(Categoria categoria);

    void delete(Long id);

    Categoria findById(Long id);

    List<Categoria> findAll();
}
