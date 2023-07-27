package com.vertis.demo.api.model;
import java.util.Date;

import com.vertis.demo.api.model.input.CategoriaInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoModel {

	private Long id;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private Double valor;
	private Date dataFabricacao;

	private CategoriaInput categoria;
}
