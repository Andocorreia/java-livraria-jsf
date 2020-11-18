package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.livraria.bean.entity.EditoraEntity;

@ManagedBean
public class EditoraBean {

	private EditoraEntity editoraEntity = new EditoraEntity();

	public void gravar() {
		System.out.println("Passou EditoraEntity: " + this.editoraEntity.getNome());
	}

	public EditoraEntity getEditoraEntity() {
		return editoraEntity;
	}

}
