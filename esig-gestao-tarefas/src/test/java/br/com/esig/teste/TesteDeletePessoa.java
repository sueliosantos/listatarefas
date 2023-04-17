package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TesteDeletePessoa {
	@Test
	public void TesteDelete() throws Exception {
		GenericDao<UsuarioPessoa> genericDao = new GenericDao<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(3L);
		pessoa = genericDao.pesquisar(pessoa);
		
		
		genericDao.delete(pessoa);
		
		System.out.println("Excluído com sucesso");
		
	}

}
