package br.com.livraria.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.livraria.model.Model;

public class GenericDao<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final EntityManager em;
	private final Class<T> classe;

	public GenericDao(final EntityManager em, final Class<T> classe) {
		this.classe = classe;
		this.em = em;
	}

	public void adiciona(final Model model) {
		em.persist(model);
	}

	public void remove(final Integer id) {
		em.remove(this.find(id));
	}

	public void atualiza(final T model) {
		em.merge(model);
	}

	public Collection<T> listaTodos() {

		final CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);

		query.select(query.from(classe));

		final Collection<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(final Integer id) {

		final T data = this.find(id);

		return data;

	}

	private T find(final Integer id) {
		return em.find(classe, id);
	}
}
