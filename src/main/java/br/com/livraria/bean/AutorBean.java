package br.com.livraria.bean;

import br.com.livraria.bean.entity.AutorEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.AutorModel;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutorBean {

	private AutorEntity autorEntity = new AutorEntity();

	public void gravar() {
		final GenericDao<AutorModel> dao = new GenericDao<>();
		final AutorModel model = new AutorModel();
		model.setNome(autorEntity.getNome());
		dao.adiciona(model);
		autorEntity = new AutorEntity();
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}
}
