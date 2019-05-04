
package br.ifrn.edu.livraria.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "AUTORES")
public class Autor extends AbstractEntity<Long>{
	
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros;
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(name = "email", nullable = false, unique = true, length = 40)
	private String email;
	
	@Column(name = "cpf", nullable = false, unique = true, length = 14)
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
