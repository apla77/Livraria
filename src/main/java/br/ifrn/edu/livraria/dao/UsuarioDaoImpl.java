package br.ifrn.edu.livraria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.domain.Usuario;

@Repository
public class UsuarioDaoImpl  extends AbstractDao<Usuario, Long> implements UsuarioDao{

	@Override
	public List<Usuario> findByUsuarioId(Long id) {
		
		return createQuery("select u from usuario u where u.id = ?1", id);
	}

	@Override
	public List<Usuario> findByNome(String nome) {
		
		return createQuery("select u from Usuario u where u.nome like concat('%',?1,'%') ", nome);
	}

}
