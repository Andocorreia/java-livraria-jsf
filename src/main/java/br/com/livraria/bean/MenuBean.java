package br.com.livraria.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int currentTab;

	@Inject
	private FacesContext content;

	public int getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(final int currentTab) {
		this.currentTab = currentTab;
	}

	public String changeActiveTab(final int currentTab) {
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
