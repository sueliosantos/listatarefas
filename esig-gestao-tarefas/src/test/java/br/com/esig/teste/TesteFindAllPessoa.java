package br.com.esig.teste;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TesteFindAllPessoa {
	@Test
	public void TestePesquisar() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		List<UsuarioPessoa> list = genericDao.findAll(UsuarioPessoa.class);
		
		for (UsuarioPessoa p : list) {
			System.out.println(p.getNome());
			System.out.println("-------------");
		}
	}

}
