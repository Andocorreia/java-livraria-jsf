package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.livraria.bean.entity.UsuarioEntity;

@ManagedBean
public class UsuarioBean {

	private UsuarioEntity usuarioEntity = new UsuarioEntity();

	public void gravar() {
		System.out.println("Passou UsuarioBean: " + this.usuarioEntity.getUsuario());
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

}
