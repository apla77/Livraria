package br.ifrn.edu.livraria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ifrn.edu.livraria.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "LIVROS")
public class Livro extends AbstractEntity<Long>{

	@Column(nullable = false, unique = true)
	private String titulo;
	
	@Column(nullable = false, unique = true)
	private String sinopse;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id_fk")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "autor_id_fk")
	private Autor autor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
