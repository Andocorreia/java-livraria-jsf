package br.com.livraria.util;

import java.io.Serializable;

import br.com.livraria.dao.UsuarioDao;
import br.com.livraria.model.UsuarioModel;

public class PopulaBanco implements Serializable {

	public static void main(final String[] args) {

		final UsuarioModel usuario = new UsuarioModel();
		usuario.setUsuario("teste");
		usuario.setSenha("teste");
		usuario.setEmail("teste@teste.com.br");
		usuario.setBloqueado(false);
		new UsuarioDao().adiciona(usuario);

	}
}
