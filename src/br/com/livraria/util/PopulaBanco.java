package br.com.livraria.util;

import br.com.livraria.dao.GenericDao;
import br.com.livraria.model.UsuarioModel;

public class PopulaBanco {

	public static void main(final String[] args) {

		final GenericDao<UsuarioModel> dao = new GenericDao<>();
		final UsuarioModel usuario = new UsuarioModel();
		usuario.setUsuario("ADMIN");
		usuario.setSenha("SENHA");
		usuario.setEmail("email@email.com.br");
		usuario.setBloqueado(false);
		dao.adiciona(usuario);

	}
}
