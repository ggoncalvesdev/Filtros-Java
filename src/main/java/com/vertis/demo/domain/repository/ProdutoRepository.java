package com.vertis.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vertis.demo.domain.model.Produto;
/**
 * Interface de repositório para a entidade Produto.
 * Extende JpaRepository para herdar os métodos padrão de operações de CRUD
 * e JpaSpecificationExecutor para suportar consultas dinâmicas baseadas em especificações.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

}