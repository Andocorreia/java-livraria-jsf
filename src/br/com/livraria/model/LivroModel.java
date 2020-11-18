package br.com.livraria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "livro")
public class LivroModel implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String titulo;
	private String summary;
	private LocalDate dataLancamento;
	private Integer paginas;

	@ManyToMany
	private Collection<AutorModel> autor;

	@ManyToOne
	private EditoraModel editora;

	private BigDecimal valorUnitario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(final Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(final String summary) {
		this.summary = summary;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(final LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(final Integer paginas) {
		this.paginas = paginas;
	}

	public Collection<AutorModel> getAutor() {
		return autor;
	}

	public void setAutor(final AutorModel autor) {
		this.autor.add(autor);
	}

	public EditoraModel getEditora() {
		return editora;
	}

	public void setEditora(final EditoraModel editora) {
		this.editora = editora;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(final BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
