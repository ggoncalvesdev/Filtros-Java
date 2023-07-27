package com.vertis.demo.domain.service.spec.statics;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.vertis.demo.domain.model.Categoria;
import com.vertis.demo.domain.model.Produto;

import jakarta.persistence.criteria.Join;

/**
 * Classe utilitária que contém métodos estáticos para criar Specifications (predicados)
 * utilizados na construção de consultas dinâmicas para a entidade Produto.
 * Esses métodos são usados pela classe ProdutoSpecification para combinar os critérios
 * de filtragem fornecidos pelo objeto ProdutoInput.
 */
public class ProdutoStaticFunctionSpec {

	// Construtor privado para evitar instanciação acidental da classe utilitária.
	private ProdutoStaticFunctionSpec() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Cria uma Specification para filtrar produtos pelo ID.
	 *
	 * @param id ID do produto a ser filtrado.
	 * @return Specification que filtra produtos pelo ID fornecido.
	 */
	public static Specification<Produto> porId(Long id) {
			return (root, query, criteriaBuilder) -> 
							criteriaBuilder.equal(root.get("id"), id);

	}
	
	/**
	 * Cria uma Specification para filtrar produtos pelo nome.
	 *
	 * @param nome Nome do produto a ser filtrado.
	 * @return Specification que filtra produtos pelo nome fornecido (busca por correspondência parcial, ignorando case).
	 */
	public static Specification<Produto> porNome(String nome) {
			return (root, query, criteriaBuilder) -> 
							criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")),
								"%" + nome.toLowerCase() + "%");

	}

	/**
	 * Cria uma Specification para filtrar produtos pela descrição.
	 *
	 * @param descricao Descrição do produto a ser filtrado.
	 * @return Specification que filtra produtos pela descrição fornecida (busca por correspondência parcial, ignorando case).
	 */
	public static Specification<Produto> porDescricao(String descricao) {
			return (root, query, criteriaBuilder) -> 
								criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")),
									"%" + descricao.toLowerCase() + "%");

	}

	/**
	 * Cria uma Specification para filtrar produtos pela quantidade em estoque.
	 *
	 * @param qtdEstoque Quantidade em estoque do produto a ser filtrado.
	 * @return Specification que filtra produtos pela quantidade em estoque fornecida.
	 */
	public static Specification<Produto> porQtdEstoque(Integer qtdEstoque) {
			return (root, query, criteriaBuilder) -> 
							criteriaBuilder.equal(root.get("qtdEstoque"), qtdEstoque);

	}

	/**
	 * Cria uma Specification para filtrar produtos pela data de fabricação.
	 *
	 * @param dataFabricacao Data de fabricação do produto a ser filtrado.
	 * @return Specification que filtra produtos pela data de fabricação fornecida.
	 */
	public static Specification<Produto> porDataFabricacao(Date dataFabricacao) {
			return (root, query, criteriaBuilder) -> 
							criteriaBuilder.equal(root.get("dataFabricacao"), dataFabricacao);

	}
	
	/**
	 * Cria uma Specification para filtrar produtos pelo preço maior que o valor fornecido.
	 *
	 * @param valor Valor a ser utilizado como limite inferior para o preço.
	 * @return Specification que filtra produtos pelo preço maior que o valor fornecido.
	 */
	public static Specification<Produto> comPrecoMaiorQue(Double valor) {
		return (root, query, criteriaBuilder) ->
						criteriaBuilder.greaterThan(root.get("valor"), valor);
	}

	/**
	 * Cria uma Specification para filtrar produtos pela categoria.
	 *
	 * @param categoria Nome da categoria a ser filtrada.
	 * @return Specification que filtra produtos pela categoria fornecida (busca por correspondência parcial, ignorando case).
	 */
	public static Specification<Produto> porCategoria(String categoria) {
			return (root, query, cb) -> {
				// Realiza o join com a entidade Categoria para permitir o filtro pela categoria.
				Join<Categoria, Produto> contaJoin = root.join("categoria");
				// Cria um predicado para filtrar pela categoria, usando um like para busca por correspondência parcial, ignorando case.
				return cb.like(cb.lower(contaJoin.get("nome")), "%" + categoria.toLowerCase() + "%");
			};
	}
}
