package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TesteUpdatePessoa {
	@Test
	public void TesteUpdate() {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(3L);
		pessoa = genericDao.pesquisar(pessoa);
		
		pessoa.setNome("Giovanna Massa");
		pessoa.setEmail("gigimassa@gmail.com");
		
		pessoa =  genericDao.updateMarge(pessoa);
		
		System.out.println(pessoa);
		
	}

}
