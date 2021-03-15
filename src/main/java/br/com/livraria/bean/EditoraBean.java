package br.com.livraria.bean;

import br.com.livraria.bean.entity.EditoraEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.AutorModel;
import br.com.livraria.model.EditoraModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Collection;

@ManagedBean
public class EditoraBean {

	private EditoraEntity editoraEntity = new EditoraEntity();

	public void gravar() {

		if(this.editoraEntity.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Nome Obrigatório"));
		}else {
			final GenericDao<EditoraModel> dao = new GenericDao<>();
			final EditoraModel model = new EditoraModel();
			model.setNome(editoraEntity.getNome());
			if(editoraEntity.getCodigo() == null){
				dao.adiciona(model);
			} else{
				model.setCodigo(editoraEntity.getCodigo());
				dao.atualiza(model);
			}
			editoraEntity = new EditoraEntity();
		}
	}

	public Collection<EditoraModel> getTodasEditoras() {
		final GenericDao<EditoraModel> dao = new GenericDao<>();
		return dao.listaTodos(EditoraModel.class);
	}

	public EditoraEntity getEditoraEntity() {
		return editoraEntity;
	}

	public void remover(EditoraModel editora){
		new GenericDao<EditoraModel>().remove(EditoraModel.class, editora.getCodigo());
	}

	public void alterar(EditoraModel editora){
		this.editoraEntity.setCodigo(editora.getCodigo());
		this.editoraEntity.setNome(editora.getNome());
	}

}
