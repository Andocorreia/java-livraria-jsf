package br.com.livraria.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.livraria.model.Model;
import br.com.livraria.util.CreateEntityManager;

public class GenericDao<T> {

	private final EntityManager em = new CreateEntityManager().getEntityManager();

	public void adiciona(final Model model) {
		em.getTransaction().begin();

		em.persist(model);

		em.getTransaction().commit();

		em.close();

	}

	public void remove(final Model model) {

		em.getTransaction().begin();

		em.remove(model);

		em.getTransaction().commit();

		em.close();
	}

	public void atualiza(final T model) {
		em.getTransaction().begin();

		em.merge(model);

		em.getTransaction().commit();
		em.close();

	}

	public Collection<T> listaTodos(final Class<T> model) {

		final CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(model);

		query.select(query.from(model));

		final Collection<T> lista = em.createQuery(query).getResultList();

		em.close();

		return lista;
	}

	public T buscaPorId(final Class<T> classe, final Integer id) {

		final T data = em.find(classe, id);

		em.close();

		return data;

	}
}
