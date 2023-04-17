package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TesteSalvarPessoa {
	@Test
	public void TesteHibernateUtil() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setNome("João Maria");
		pessoa.setIdade(39);
		pessoa.setEmail("jm@gmail.com");
		pessoa.setLogin("jm");
		pessoa.setSenha("123456");
		
		genericDao.salvar(pessoa);
	}

}
