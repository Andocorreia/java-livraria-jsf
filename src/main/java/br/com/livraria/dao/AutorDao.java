package br.com.livraria.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.livraria.model.AutorModel;
import br.com.livraria.model.Model;


public class AutorDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private GenericDao<AutorModel> dao;

	@PostConstruct
	void init() {
		this.dao = new GenericDao<AutorModel>(this.em, AutorModel.class);
	}

	public void adiciona(final Model model) {
		dao.adiciona(model);
	}

	public void remove(final Integer id) {
		dao.remove(id);
	}

	public void atualiza(final AutorModel model) {
		dao.atualiza(model);
	}

	public Collection<AutorModel> listaTodos(final Class<AutorModel> model) {
		return dao.listaTodos();
	}

	public AutorModel buscaPorId(final Class<AutorModel> classe, final Integer id) {
		return dao.buscaPorId(id);
	}
}
