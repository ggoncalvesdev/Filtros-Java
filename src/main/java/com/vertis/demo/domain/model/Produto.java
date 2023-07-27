package com.vertis.demo.domain.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "produto")
@Data
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 5, max = 30)
  @Column(name = "nome", nullable = false, length = 30)
  private String nome;

  @NotNull
  @Size(min = 5, max = 200)
  @Column(name = "descricao", nullable = false, length = 200)
  private String descricao;

  @NotNull
  @Column(name = "qtd_estoque", nullable = false, length = 20)
  private Integer qtdEstoque;

  @NotNull
  @Column(name = "valor", nullable = false, length = 10)
  private Double valor;

  @Past
  @Column(name = "data_fabricacao")
  private Date dataFabricacao;

  @ManyToOne
  @JoinColumn(name = "id_categoria")
  private Categoria categoria;
  
}
