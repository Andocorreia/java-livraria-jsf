package br.com.livraria.seguranca;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener {
	@Override
	public void afterPhase(final PhaseEvent evento) {
		FacesContext content = evento.getFacesContext();
		String nomePagina = content.getViewRoot().getViewId();

		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}
		String usuarioLogado = (String) content.getExternalContext().getSessionMap().get("usuarioLogado");

		if (usuarioLogado != null) {
			return;
		}

		NavigationHandler handler = content.getApplication().getNavigationHandler();
		handler.handleNavigation(content, null, "/login.xhtml?faces-redirect=true");

	}

	@Override
	public void beforePhase(final PhaseEvent phaseEvent) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
