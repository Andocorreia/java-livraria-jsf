package br.com.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.livraria.bean.entity.LoginEntity;
import br.com.livraria.dao.UsuarioDao;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext content;

	@Inject
	UsuarioDao usuarioDao;

	private LoginEntity loginEntity = new LoginEntity();

	public String logar() {
		if (usuarioDao.login(this.loginEntity.getEmail(), this.loginEntity.getSenha())) {
			content.getExternalContext().getSessionMap().put("usuarioLogado", this.loginEntity.getEmail());
			return "livro?daces-redirect=true";
		}
		content.getExternalContext().getFlash().setKeepMessages(true);
		content.addMessage("form:email", new FacesMessage("Erro: Usuário não encontrado!"));
		return "login?faces-redirect=true";
	}

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}

	public void setLoginEntity(final LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}

}
