package br.com.livraria.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.bean.entity.UsuarioEntity;
import br.com.livraria.dao.UsuarioDao;
import br.com.livraria.model.UsuarioModel;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioEntity usuarioEntity = new UsuarioEntity();

	@Inject
	private UsuarioDao usuarioDao;

	public void gravar() {
		if (!validacoes()) {

			final UsuarioModel model = new UsuarioModel();
			model.setEmail(usuarioEntity.getEmail());
			model.setUsuario(usuarioEntity.getUsuario());
			model.setSenha(usuarioEntity.getSenha());
			model.setBloqueado(false);
			if (this.usuarioEntity.getCodigoUsuario() == null) {
				usuarioDao.adiciona(model);
			}
			else {
				model.setCodigo(usuarioEntity.getCodigoUsuario());
				usuarioDao.atualiza(model);
			}
			usuarioEntity = new UsuarioEntity();
		}
	}

	public Collection<UsuarioModel> getTodosUsuarios() {

		return usuarioDao.listaTodos(UsuarioModel.class);
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void remover(final UsuarioModel usuario) {
		usuarioDao.remove(usuario.getCodigo());
	}

	public void alterar(final UsuarioModel usuario) {
		this.usuarioEntity.setCodigoUsuario(usuario.getCodigo());
		this.usuarioEntity.setEmail(usuario.getEmail());
		this.usuarioEntity.setSenha(usuario.getSenha());
		this.usuarioEntity.setUsuario(usuario.getUsuario());
	}

	private Boolean validacoes() {

		Boolean erro = false;
		if (this.usuarioEntity.getEmail().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo E-mail Obrigatório"));
			erro = true;
		}

		if (this.usuarioEntity.getUsuario().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Usuário Obrigatório"));
			erro = true;
		}

		if (this.usuarioEntity.getSenha().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Senhas obrigatório"));
			erro = true;
		}

		if (!this.usuarioEntity.getSenha().equals(this.usuarioEntity.getConfirmacaoSenha())) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Senhas não conferem"));
			erro = true;
		}
		return erro;
	}
}
