package br.ifrn.edu.livraria.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.ifrn.edu.livraria.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "LIVROS")
public class Livro extends AbstractEntity<Long>{

	@Column(nullable = false, unique = true, length = 60)
	private String titulo;
	
	@Column(nullable = false, unique = true, length = 60)
	private String sinopse;
	
	@Column(nullable = false, unique = true)
	private int ano;
	
	@Column(nullable = false, unique = true)
	private int slbn;
	
	@Column(nullable = false, unique = true)
	private int edicao;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(3,2) DEFAULT 0.00")
	private double peso;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private double valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id_fk")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "autor_id_fk")
	private Autor autor;
	
	@ManyToOne
	@JoinColumn(name = "editora_id_fk")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id_fk")
	private Pedido pedido;

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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSlbn() {
		return slbn;
	}

	public void setSlbn(int slbn) {
		this.slbn = slbn;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
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

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
    
}
