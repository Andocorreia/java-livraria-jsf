package br.com.livraria.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.bean.entity.EditoraEntity;
import br.com.livraria.dao.EditoraDao;
import br.com.livraria.model.EditoraModel;

@Named
@ViewScoped
public class EditoraBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private EditoraEntity editoraEntity = new EditoraEntity();

	@Inject
	private EditoraDao editoraDao;

	public void gravar() {

		if (this.editoraEntity.getNome().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(this.editoraEntity.getNome(), new FacesMessage("Erro-Campo Nome Obrigatório"));
		}
		else {

			final EditoraModel model = new EditoraModel();
			model.setNome(editoraEntity.getNome());
			if (editoraEntity.getCodigo() == null) {
				editoraDao.adiciona(model);
			}
			else {
				model.setCodigo(editoraEntity.getCodigo());
				editoraDao.atualiza(model);
			}
			editoraEntity = new EditoraEntity();
		}
	}

	public Collection<EditoraModel> getTodasEditoras() {
		return editoraDao.listaTodos(EditoraModel.class);
	}

	public EditoraEntity getEditoraEntity() {
		return editoraEntity;
	}

	public void remover(final EditoraModel editora) {
		editoraDao.remove(editora.getCodigo());
	}

	public void alterar(final EditoraModel editora) {
		this.editoraEntity.setCodigo(editora.getCodigo());
		this.editoraEntity.setNome(editora.getNome());
	}

}
