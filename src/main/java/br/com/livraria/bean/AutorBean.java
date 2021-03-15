package br.com.livraria.bean;

import br.com.livraria.bean.entity.AutorEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.AutorModel;
import br.com.livraria.model.LivroModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Collection;

@ManagedBean
public class AutorBean {

	private AutorEntity autorEntity = new AutorEntity();

	public void gravar() {
		if(this.autorEntity.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Nome Obrigatório"));
		} else{
			final GenericDao<AutorModel> dao = new GenericDao<>();
			final AutorModel model = new AutorModel();
			model.setNome(autorEntity.getNome());

			if (this.autorEntity.getCodigo() == null) {
				dao.adiciona(model);
			} else {
				model.setCodigo(this.autorEntity.getCodigo());
				dao.atualiza(model);
			}

			autorEntity = new AutorEntity();
		}
	}

	public Collection<AutorModel> getTodosAutores() {
		final GenericDao<AutorModel> dao = new GenericDao<>();
		return dao.listaTodos(AutorModel.class);
	}

	public AutorEntity getAutorEntity() {
		return autorEntity;
	}

	public void remover(AutorModel autor){
		new GenericDao<AutorModel>().remove(AutorModel.class, autor.getCodigo());
	}

	public void alterar(AutorModel autor){
		this.autorEntity.setCodigo(autor.getCodigo());
		this.autorEntity.setNome(autor.getNome());
	}
}
