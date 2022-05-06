package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedores")
public class Fornecedor {
	@Column(name = "for_codigo")
	private Long codigo;

	@Column(name = "for_descricao")
	private String descricao;
}
