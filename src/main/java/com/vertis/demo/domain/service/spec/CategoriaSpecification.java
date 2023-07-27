package com.vertis.demo.domain.service.spec;

import org.springframework.data.jpa.domain.Specification;

import com.vertis.demo.api.model.input.CategoriaInput;
import com.vertis.demo.domain.model.Categoria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CategoriaSpecification implements Specification<Categoria> {

	private static final long serialVersionUID = 1L;

	private transient CategoriaInput categoriaInput;

	public CategoriaSpecification(CategoriaInput categoriaInput) {
		this.categoriaInput = categoriaInput;
	}

	@Override
	public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Specification<Categoria> specification = Specification.where(null);

    return specification.toPredicate(root, query, builder);
	}
}
