package br.ifrn.edu.livraria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.domain.Cidade;


@Repository
public class CidadeDaoImpl extends AbstractDao<Cidade, Long> implements CidadeDao{

	@Override
	public List<Cidade> findByNome(String nome) {
		return createQuery("select c from Cidade c where c.nome like concat('%',?1,'%') ", nome);
	}

}
