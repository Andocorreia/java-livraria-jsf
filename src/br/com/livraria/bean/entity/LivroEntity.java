package br.com.livraria.bean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class LivroEntity {

	private Integer codigo;
	private String titulo;
	private String summary;
	private String dataLancamento;
	private Integer paginas;
	private BigDecimal valorUnitario;
	private String editora;
	private Collection<String> autor = new ArrayList<>();

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(final Integer codigo) {
		this.codigo = codigo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(final String editora) {
		this.editora = editora;
	}

	public Collection<String> getAutor() {
		return autor;
	}

	public void setAutor(final String autor) {
		this.autor.add(autor);
	}

	public LivroEntity() {
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
