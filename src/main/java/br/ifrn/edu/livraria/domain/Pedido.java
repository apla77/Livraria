package br.ifrn.edu.livraria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private LocalDate dataPedido;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valorTotal;
	
	@Column(nullable = false, unique = true)
	private int quantidade;
}
