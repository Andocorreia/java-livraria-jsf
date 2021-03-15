package br.com.livraria.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class LivroEntity {

	private Collection<AutorEntity> autor = new ArrayList<>();
	private String titulo;
	private Integer codigo;
	private String summary;
	private String dataLancamento;
	private Integer paginas;
	private BigDecimal valorUnitario;
	private EditoraEntity editora;

	public Collection<AutorEntity> getAutor() {
		return autor;
	}

	public void setAutor(final AutorEntity autor) {
		this.autor.add(autor);
	}

	public Integer getCodigo() {

		return codigo;
	}

	public void setCodigo(final Integer codigo) {

		this.codigo = codigo;
	}

	public EditoraEntity getEditora() {
		return editora;
	}

	public void setEditora(final EditoraEntity editora) {
		this.editora = editora;
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
		return dataLancamento;
	}

	public void setDataLancamento(final String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(final Integer paginas) {
		this.paginas = paginas;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(final BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
