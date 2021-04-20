package br.com.livraria.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.livraria.model.EditoraModel;
import br.com.livraria.model.Model;

public class EditoraDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager em;

	private GenericDao<EditoraModel> dao;

	@PostConstruct
	void init() {
		this.dao = new GenericDao<>(this.em, EditoraModel.class);
	}

	public void adiciona(final Model model) {
		dao.adiciona(model);
	}

	public void remove(final Integer id) {
		dao.remove(id);
	}

	public void atualiza(final EditoraModel model) {
		dao.atualiza(model);
	}

	public Collection<EditoraModel> listaTodos(final Class<EditoraModel> model) {
		return dao.listaTodos();
	}

	public EditoraModel buscaPorId(final Class<EditoraModel> classe, final Integer id) {
		return dao.buscaPorId(id);
	}

}
