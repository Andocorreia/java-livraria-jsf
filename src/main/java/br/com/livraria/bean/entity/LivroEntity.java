package br.com.livraria.bean.entity;

import java.math.BigDecimal;

public class LivroEntity {

	private Integer autor;
	private String titulo;
	private Integer codigo;
	private String summary;
	private String dataLancamento;
	private Integer paginas;
	private BigDecimal valorUnitario;
	private Integer editora;

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(final Integer autor) {
		this.autor = autor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(final Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getEditora() {
		return editora;
	}

	public void setEditora(final Integer editora) {
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
