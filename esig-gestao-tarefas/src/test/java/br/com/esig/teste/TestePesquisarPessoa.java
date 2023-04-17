package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TestePesquisarPessoa {
	@Test
	public void TestePesquisar() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		pessoa = genericDao.pesquisar(pessoa);
		
		System.out.println(pessoa);
	}

}
