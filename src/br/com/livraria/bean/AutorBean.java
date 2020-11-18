package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.livraria.bean.entity.AutorEntity;

@ManagedBean
public class AutorBean {

	private AutorEntity autorEntity = new AutorEntity();

	public void gravar() {
		System.out.println("Passou AutorBean: " + this.autorEntity.getNome());
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}
}
