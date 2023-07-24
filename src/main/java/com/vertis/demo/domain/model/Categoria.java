package com.vertis.demo.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "CATEGORIA")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(min = 5, max = 60)
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@NotNull
	@Size(min = 5, max = 200)
	@Column(name = "descricao", nullable = false, length = 200)
	private String descricao;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Produto> produto = new ArrayList<>();

}
