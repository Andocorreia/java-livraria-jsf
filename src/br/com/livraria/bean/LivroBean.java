package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.livraria.bean.entity.LivroEntity;

@ManagedBean
public class LivroBean {

	private LivroEntity LivroEntity = new LivroEntity();

	public LivroEntity getLivroEntity() {
		return LivroEntity;
	}

	public void gravar() {
		System.out.println("Passou LivroBean: " + this.LivroEntity.getTitulo());
	}

}
