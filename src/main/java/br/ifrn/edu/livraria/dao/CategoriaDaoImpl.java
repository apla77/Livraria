package br.ifrn.edu.livraria.dao;

import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.domain.Categoria;

@Repository
public class CategoriaDaoImpl extends AbstractDao<Categoria, Long> implements CategoriaDao{

}
