package br.ifrn.edu.livraria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
 

@SuppressWarnings("serial")
@Entity
@Table(name = "CIDADES")
public class Cidade extends AbstractEntity<Long>{
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Column(nullable = false, unique = true, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;

	public String getNome() { 
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
	
}
