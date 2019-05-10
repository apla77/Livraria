package br.ifrn.edu.livraria.dao;

import java.util.List;

import br.ifrn.edu.livraria.domain.Usuario;

public interface UsuarioDao {

	void save(Usuario usuario);

    void update(Usuario usuario);

    void delete(Long id);

    Usuario findById(Long id);

    List<Usuario> findAll();
    
    List<Usuario> findByUsuarioId(Long id);
    
    List<Usuario> findByNome(String nome); 

}
