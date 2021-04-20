package br.com.livraria.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.bean.entity.AutorEntity;
import br.com.livraria.dao.AutorDao;
import br.com.livraria.model.AutorModel;

@Named
@ViewScoped
public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AutorEntity autorEntity = new AutorEntity();

	@Inject
	private AutorDao autorDao;

	public void gravar() {
		if (this.autorEntity.getNome().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Nome Obrigatório"));
		}
		else {

			final AutorModel model = new AutorModel();
			model.setNome(autorEntity.getNome());

			if (this.autorEntity.getCodigo() == null) {
				autorDao.adiciona(model);
			}
			else {
				model.setCodigo(this.autorEntity.getCodigo());
				autorDao.atualiza(model);
			}

			autorEntity = new AutorEntity();
		}
	}

	public Collection<AutorModel> getTodosAutores() {
		return autorDao.listaTodos(AutorModel.class);
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}

	public void remover(final AutorModel autor) {
		autorDao.remove(autor.getCodigo());
	}

	public void alterar(final AutorModel autor) {
		this.autorEntity.setCodigo(autor.getCodigo());
		this.autorEntity.setNome(autor.getNome());
	}
}
