package com.vertis.demo.api.model.input;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {
  
	private Long id;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private Double valor;
	private Date dataFabricacao;

	private CategoriaInput categoria;
}
