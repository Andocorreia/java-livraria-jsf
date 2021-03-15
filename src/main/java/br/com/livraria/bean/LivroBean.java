package br.com.livraria.bean;

import br.com.livraria.bean.entity.AutorEntity;
import br.com.livraria.bean.entity.EditoraEntity;
import br.com.livraria.bean.entity.LivroEntity;
import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.AutorModel;
import br.com.livraria.model.EditoraModel;
import br.com.livraria.model.LivroModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

@ManagedBean
@ViewScoped
public class LivroBean {
	private LivroEntity livroEntity = new LivroEntity();
	private Integer autorId;
	private Integer editoraId;
	private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public void gravar() {

		if (!validacao()) {
			final GenericDao<LivroModel> dao = new GenericDao<>();
			final LivroModel model = new LivroModel();

			model.setAutor(new GenericDao<AutorModel>().buscaPorId(AutorModel.class, this.autorId));
			model.setEditora(getEditoraModel());
			model.setDataLancamento(convertStringToDate(livroEntity.getDataLancamento()));
			model.setPaginas(livroEntity.getPaginas());
			model.setSummary(livroEntity.getSummary());
			model.setTitulo(livroEntity.getTitulo());
			model.setValorUnitario(livroEntity.getValorUnitario());

			if (this.livroEntity.getCodigo() == null) {
				dao.adiciona(model);
			}
			else {
				model.setCodigo(this.livroEntity.getCodigo());
				dao.atualiza(model);
			}
			livroEntity = new LivroEntity();
		}
	}

	public void editarLivro(final LivroModel livro) {
		this.livroEntity.setCodigo(livro.getCodigo());
		this.livroEntity.setSummary(livro.getSummary());
		this.livroEntity.setTitulo(livro.getTitulo());
		this.livroEntity.setValorUnitario(livro.getValorUnitario());
		this.livroEntity.setPaginas(livro.getPaginas());
		this.livroEntity.setDataLancamento(livro.getDataLancamento());

		livro.getAutor().stream().forEach(autor -> {
			this.autorId = autor.getCodigo();
			AutorEntity autorEntity = new AutorEntity();
			autorEntity.setCodigo(autor.getCodigo());
			autorEntity.setNome(autor.getNome());
			this.livroEntity.setAutor(autorEntity);
		});

		this.editoraId = livro.getEditora().getCodigo();
		EditoraEntity editoraEntity = new EditoraEntity();
		editoraEntity.setCodigo(livro.getEditora().getCodigo());
		editoraEntity.setNome(livro.getEditora().getNome());
		this.livroEntity.setEditora(editoraEntity);
	}

	private EditoraModel getEditoraModel() {
		return new GenericDao<EditoraModel>().buscaPorId(EditoraModel.class, this.editoraId);
	}

	public void removerLivro(final LivroModel livro) {
		new GenericDao<LivroModel>().remove(LivroModel.class, livro.getCodigo());
	}

	public void setAutorId(final Integer id) {
		this.autorId = (id);
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setEditoraId(final Integer id) {
		this.editoraId = id;
	}

	public Integer getEditoraId() {
		return editoraId;
	}

	public LivroEntity getLivroEntity() {
		return livroEntity;
	}

	public Collection<AutorEntity> getListaAutores() {
		Collection<AutorEntity> autorEntity = new ArrayList<>();
		new GenericDao<AutorModel>().listaTodos(AutorModel.class).stream().forEach(autor -> {
			AutorEntity entity = new AutorEntity();
			entity.setCodigo(autor.getCodigo());
			entity.setNome(autor.getNome());
			autorEntity.add(entity);
		});
		return autorEntity;
	}

	public Collection<EditoraEntity> getListaEditoras() {
		Collection<EditoraEntity> editoraEntity = new ArrayList<>();

		new GenericDao<EditoraModel>().listaTodos(EditoraModel.class).stream().forEach(editora -> {
			EditoraEntity entity = new EditoraEntity();
			entity.setCodigo(editora.getCodigo());
			entity.setNome(editora.getNome());
			editoraEntity.add(entity);
		});
		return editoraEntity;
	}

	public Collection<LivroModel> getListaLivros() {
		return new GenericDao<LivroModel>().listaTodos(LivroModel.class);
	}

	private LocalDate convertStringToDate(final String data) {
		return LocalDate.parse(data, dateFormater);
	}

	private boolean validacao() {
		Boolean erro = false;
		if (this.livroEntity.getTitulo().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Titulo Obrigatório"));
			erro = true;
		}
		if (this.livroEntity.getSummary().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Resumo Obrigatório"));
			erro = true;
		}
		if (this.livroEntity.getDataLancamento().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Data de Lançamento Obrigatório"));
			erro = true;
		}
		if (this.livroEntity.getPaginas() == null || this.livroEntity.getPaginas() == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Paginas Obrigatório"));
			erro = true;
		}
		if (this.livroEntity.getValorUnitario() == null || this.livroEntity.getValorUnitario().compareTo(BigDecimal.ZERO) == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro-Campo Valor Obrigatório"));
			erro = true;
		}
		return erro;
	}
}
