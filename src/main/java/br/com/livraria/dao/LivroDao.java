package br.com.livraria.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.livraria.util.Transactional;
import br.com.livraria.model.LivroModel;
import br.com.livraria.model.Model;

public class LivroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private GenericDao<LivroModel> dao;

	@PostConstruct
	void init() {
		this.dao = new GenericDao<>(this.em, LivroModel.class);
	}

	@Transactional
	public void adiciona(final Model model) {
		dao.adiciona(model);
	}

	@Transactional
	public void remove(final Integer id) {
		dao.remove(id);
	}

	@Transactional
	public void atualiza(final LivroModel model) {
		dao.atualiza(model);
	}

	public Collection<LivroModel> listaTodos(final Class<LivroModel> model) {
		return dao.listaTodos();
	}

	public LivroModel buscaPorId(final Class<LivroModel> classe, final Integer id) {
		return dao.buscaPorId(id);
	}
}
