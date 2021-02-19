package br.com.livraria.bean;

import br.com.livraria.bean.entity.UsuarioEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.UsuarioModel;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	private UsuarioEntity usuarioEntity = new UsuarioEntity();

	public void gravar() {
		final GenericDao<UsuarioModel> dao = new GenericDao<>();
		final UsuarioModel model = new UsuarioModel();
		model.setEmail(usuarioEntity.getEmail());
		model.setUsuario(usuarioEntity.getUsuario());
		model.setSenha(usuarioEntity.getSenha());
		model.setBloqueado(false);
		dao.adiciona(model);
		usuarioEntity = new UsuarioEntity();
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

}
