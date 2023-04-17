package br.com.esig.teste;

import org.junit.Test;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.Tarefa;
import br.com.esig.model.UsuarioPessoa;
import br.com.esig.util.HibernateUtil;

public class TesteSalvarTarefa {
	@Test
	public void TesteHibernateUtil() {
		GenericDao<Tarefa> genericDao = new GenericDao<Tarefa>();
		GenericDao<UsuarioPessoa> daoPessoa = new GenericDao<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		pessoa = daoPessoa.pesquisar(pessoa);
		
		Tarefa tarefa = new Tarefa();
		
		tarefa.setDescricao("tarefa teste");
		tarefa.setPrioridade("ALTA");
		tarefa.setTitulo("TAREFA 1");
		tarefa.setUsuarioPessoa(pessoa);
		tarefa.setDeadline(":)");
		
		genericDao.salvar(tarefa);
	}

}
