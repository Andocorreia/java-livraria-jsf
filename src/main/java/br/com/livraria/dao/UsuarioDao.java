package br.com.livraria.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.livraria.model.Model;
import br.com.livraria.model.UsuarioModel;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	private GenericDao<UsuarioModel> dao;

	@PostConstruct
	void init() {
		this.dao = new GenericDao<UsuarioModel>(this.em, UsuarioModel.class);
	}

	public Boolean login(final String email, final String senha) {

		TypedQuery<UsuarioModel> query = em.createQuery("select u from usuario u where u.email = :pEmail and u.senha = :pSenha", UsuarioModel.class);

		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);

		try {
			final UsuarioModel result = query.getSingleResult();
		}
		catch (NoResultException e) {
			return false;
		}
		return true;
	}

	public void adiciona(final Model model) {
		dao.adiciona(model);
	}

	public void remove(final Integer id) {
		dao.remove(id);
	}

	public void atualiza(final UsuarioModel model) {
		dao.atualiza(model);
	}

	public Collection<UsuarioModel> listaTodos(final Class<UsuarioModel> model) {
		return dao.listaTodos();
	}

	public UsuarioModel buscaPorId(final Class<UsuarioModel> classe, final Integer id) {
		return dao.buscaPorId(id);
	}
}
