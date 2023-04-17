package br.com.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.esig.dao.GenericDao;
import br.com.esig.model.Tarefa;

@ManagedBean(name = "tarefaBean")
@ViewScoped
public class TarefaBean {
	private Tarefa tarefa = new Tarefa();
	private GenericDao<Tarefa> dao = new GenericDao<>();
	//private GenericDao<UsuarioPessoa> pessoaDao = new GenericDao<>();
	private List<Tarefa> list = new ArrayList<Tarefa>();
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public String salvar() {
		dao.salvar(tarefa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Tarefa cadastrada com sucesso!"));
		return "";
	}
	
	
	public String novoCadastro() {
		tarefa = new Tarefa();
		return "";
	}
	
	public List<Tarefa> getList() {
		list  = dao.findAll(Tarefa.class);
		return list;
	}

	public String delete() {
		try {
			dao.delete(tarefa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Tarefa excluída com sucesso!"));
			tarefa =  new Tarefa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	

}
