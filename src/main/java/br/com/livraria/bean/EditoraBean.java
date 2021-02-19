package br.com.livraria.bean;

import br.com.livraria.bean.entity.EditoraEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.EditoraModel;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EditoraBean {

	private EditoraEntity editoraEntity = new EditoraEntity();

	public void gravar() {
		final GenericDao<EditoraModel> dao = new GenericDao<>();
		final EditoraModel model = new EditoraModel();
		model.setNome(editoraEntity.getNome());
		dao.adiciona(model);
		editoraEntity = new EditoraEntity();
	}

	public EditoraEntity getEditoraEntity() {
		return editoraEntity;
	}

}
