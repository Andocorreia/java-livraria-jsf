package br.com.livraria.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class MenuBean {

	private int currentTab;
	private final FacesContext content = FacesContext.getCurrentInstance();

	public int getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(final int currentTab) {
		this.currentTab = currentTab;
	}

	public String changeActiveTab(int currentTab) {
		this.currentTab = currentTab;
		switch (currentTab) {
			case 0:
				return "autor?daces-redirect=true";
			case 1:
				return "editora?daces-redirect=true";
			case 2:
				return "usuario?daces-redirect=true";
			case 3:
				return "livro?daces-redirect=true";
			default:
				return logout();

		}
	}

	private String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?daces-redirect=true";
	}

}
