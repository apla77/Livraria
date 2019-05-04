package br.ifrn.edu.livraria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import br.ifrn.edu.livraria.domain.Livro;

@Repository
public class LivroDaoImpl extends AbstractDao<Livro, Long> implements LivroDao{
	
	public List<Livro> findByTitulo(String titulo) {
		
		return createQuery("select l from Livro l where l.titulo like concat('%',?1,'%') ", titulo);
	}

	@Override
		public List<Livro> findByAutorId(Long id) {
	
		return createQuery("select l from Livro l where l.autor.id = ?1", id);
	}

}
