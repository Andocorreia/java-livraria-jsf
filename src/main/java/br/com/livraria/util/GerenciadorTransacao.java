package br.com.livraria.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transactional
@Interceptor
public class GerenciadorTransacao implements Serializable {

	@Inject
	EntityManager em;

	@AroundInvoke
	public Object controleTransacao(final InvocationContext ev) throws Exception {
		em.getTransaction().begin();
		Object proceed = ev.proceed();
		em.getTransaction().commit();
		return proceed;
	}
}
