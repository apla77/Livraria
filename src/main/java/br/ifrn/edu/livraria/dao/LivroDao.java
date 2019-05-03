package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Livro;

public interface LivroDao {
	
	void save(Livro livrodao);

    void update(Livro livrodao);

    void delete(Long id);

    Livro findById(Long id);

    List<Livro> findAll();
    
    List<Livro> findByAutorId(Long id);
    
    List<Livro> findByTitulo(String nome);

}
