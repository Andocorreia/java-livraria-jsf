package br.com.livraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuario")
public class UsuarioModel implements Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoUsuario;
	private String usuario;
	private String senha;
	private String email;
	private Boolean bloqueado;

	public Integer getCodigo() {
		return codigoUsuario;
	}

	public void setCodigo(final Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(final Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
