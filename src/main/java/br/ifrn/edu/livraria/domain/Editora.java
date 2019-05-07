package br.ifrn.edu.livraria.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "EDITORAS")
public class Editora extends AbstractEntity<Long>{

	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name = "cidade", nullable = false, length = 60)
	private String cidade;

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
}
