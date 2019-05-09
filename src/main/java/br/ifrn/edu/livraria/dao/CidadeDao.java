package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Cidade;

public interface CidadeDao { 

	void save(Cidade cidade);

    void update(Cidade cidade);

    void delete(Long id);

    Cidade findById(Long id);

    List<Cidade> findAll();
    
    List<Cidade> findByNome(String nome); 
}
