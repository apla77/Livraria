package br.ifrn.edu.livraria.dao;

import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.domain.Usuario;

@Repository
public class UsuarioDaoImpl  extends AbstractDao<Usuario, Long> implements UsuarioDao{

}
