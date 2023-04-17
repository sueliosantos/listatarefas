package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.util.HibernateUtil;

public class TesteHibernate {
	@Test
	public void TesteHibernateUtil() {
		HibernateUtil.getEntityManager();
	}

}
