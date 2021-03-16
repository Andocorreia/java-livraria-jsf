package br.com.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.livraria.model.UsuarioModel;
import br.com.livraria.util.CreateEntityManager;

public class UsuarioDao {
	public Boolean login(final String email, final String senha) {
		final EntityManager em = new CreateEntityManager().getEntityManager();
		TypedQuery<UsuarioModel> query = em.createQuery("select u from usuario u where u.email = :pEmail and u.senha = :pSenha", UsuarioModel.class);

		query.setParameter("pEmail",email);
		query.setParameter("pSenha",senha);

		try {
			final UsuarioModel result = query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}

		em.close();
		return true;
	}
}
