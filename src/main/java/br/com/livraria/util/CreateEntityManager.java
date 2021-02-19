package br.com.livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateEntityManager {

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria_jsf");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
