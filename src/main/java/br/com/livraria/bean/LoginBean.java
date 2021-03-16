package br.com.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.livraria.bean.entity.LoginEntity;
import br.com.livraria.dao.UsuarioDao;

@ManagedBean
public class LoginBean {

	private LoginEntity loginEntity = new LoginEntity();
	private final FacesContext content = FacesContext.getCurrentInstance();

	public String logar() {
		if (new UsuarioDao().login(this.loginEntity.getEmail(), this.loginEntity.getSenha())) {
			content.getExternalContext().getSessionMap().put("usuarioLogado", this.loginEntity.getEmail());
			return "livro?daces-redirect=true";
		}
		content.getExternalContext().getFlash().setKeepMessages(true);
		content.addMessage("form:email", new FacesMessage("Erro: Usuário não encontrado!"));
		return "login?faces-redirect=true";
	}

	public String logout(){
		content.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?daces-redirect=true";
	}

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}

	public void setLoginEntity(final LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
}
