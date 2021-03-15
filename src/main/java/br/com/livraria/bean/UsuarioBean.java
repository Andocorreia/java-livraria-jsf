package br.com.livraria.bean;

import br.com.livraria.bean.entity.UsuarioEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.UsuarioModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Collection;

@ManagedBean
public class UsuarioBean {

	private UsuarioEntity usuarioEntity = new UsuarioEntity();

	public void gravar() {
		if (!validacoes()) {
			final GenericDao<UsuarioModel> dao = new GenericDao<>();
			final UsuarioModel model = new UsuarioModel();
			model.setEmail(usuarioEntity.getEmail());
			model.setUsuario(usuarioEntity.getUsuario());
			model.setSenha(usuarioEntity.getSenha());
			model.setBloqueado(false);
			if (this.usuarioEntity.getCodigoUsuario() == null) {
				dao.adiciona(model);
			}
			else {
				model.setCodigo(usuarioEntity.getCodigoUsuario());
				dao.atualiza(model);
			}
			usuarioEntity = new UsuarioEntity();
		}
	}

	public Collection<UsuarioModel> getTodosUsuarios() {
		final GenericDao<UsuarioModel> dao = new GenericDao<>();
		return dao.listaTodos(UsuarioModel.class);
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void remover(final UsuarioModel usuario) {
		new GenericDao<UsuarioModel>().remove(UsuarioModel.class, usuario.getCodigo());
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
