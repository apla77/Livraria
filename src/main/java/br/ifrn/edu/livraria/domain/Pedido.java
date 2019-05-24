package br.ifrn.edu.livraria.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "PEDIDOS")
public class Pedido extends AbstractEntity<Long>{

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_pedido", nullable = false, columnDefinition = "DATE")
	private Date dataPedido;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorTotal;
	
	@Column(nullable = false, unique = true)
	private int quantidade = 1;
	
	@OneToMany(mappedBy = "pedido")
	private List<Livro> livros;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id_fk")
	private Usuario usuario;

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date date) {
		this.dataPedido = date;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
