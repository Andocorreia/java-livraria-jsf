package br.com.livraria.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "livro")
public class LivroModel implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String titulo;
	private String summary;
	@Column(columnDefinition="DATE")
	private LocalDate dataLancamento;
	private Integer paginas;

	@ManyToMany(fetch = FetchType.EAGER)
	private final Collection<AutorModel> autor = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
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

	public String getDataLancamento() {
		return dataLancamento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
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
