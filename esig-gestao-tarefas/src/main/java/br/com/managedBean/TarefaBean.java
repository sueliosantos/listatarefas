package br.com.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.esig.dao.GenericDao;
import br.com.esig.enums.PrioridadaEnum;
import br.com.esig.enums.SituacaoEnum;
import br.com.esig.model.Tarefa;
import br.com.esig.model.UsuarioPessoa;

@ManagedBean(name = "tarefaBean")
@ViewScoped
public class TarefaBean {
	private Tarefa tarefa = new Tarefa();
	private UsuarioPessoa usuarioPessoa;
	private GenericDao<Tarefa> dao = new GenericDao<>();
	private GenericDao<UsuarioPessoa> daoUsuarioPessoa = new GenericDao<>();
	private List<UsuarioPessoa> listUsuarioPessoa  = new ArrayList<UsuarioPessoa>();;
	private List<Tarefa> list = new ArrayList<Tarefa>();
	
	private List<UsuarioPessoa> listBuscaPessoa = new ArrayList<UsuarioPessoa>();
	@PostConstruct
	public void init() {
		atualizaTarefasTela();
		preencherLista();
	}
	
	@SuppressWarnings("unchecked")
	private void atualizaTarefasTela() {
		list  = dao.getEntityManager().createQuery("from Tarefa t where t.situacao = 'EMANDAMENTO' ").getResultList();
	}
	 
	private void preencherLista() {
		listBuscaPessoa = daoUsuarioPessoa.findAll(UsuarioPessoa.class);
		for (UsuarioPessoa usuarioPessoa : listBuscaPessoa) {
			listUsuarioPessoa.add(usuarioPessoa);
		}	
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public String salvar() {
		try {
			dao.salvar(tarefa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Tarefa cadastrada com sucesso!"));
			atualizaTarefasTela();
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public String novo() {
		tarefa = new Tarefa();
		refresh();
		return "";
	}
	
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public List<Tarefa> getList() {
		//list  = dao.findAll(Tarefa.class);
		return list;
	}

	public String delete() {
		try {
			dao.delete(tarefa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Tarefa excluída com sucesso!"));
			atualizaTarefasTela();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String concluir() {
		try {
			tarefa.setSituacao("CONCLUIDA");
			dao.updateMarge(tarefa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Tarefa concluída com sucesso!"));
			atualizaTarefasTela();
			tarefa = new Tarefa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
    public UsuarioPessoa getUsuarioPessoa(Long id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (UsuarioPessoa usuario : listUsuarioPessoa){
            if (id.equals(new Long(usuario.getId()))){
                return usuario;
            }
        }
        return null;
    }

	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}

	public List<UsuarioPessoa> getListUsuarioPessoa() {
		return listUsuarioPessoa;
	}

	public void setListUsuarioPessoa(List<UsuarioPessoa> listUsuarioPessoa) {
		this.listUsuarioPessoa = listUsuarioPessoa;
	}
	
	public PrioridadaEnum[] getPrioridades() {
		return PrioridadaEnum.values();
	}
	
	public SituacaoEnum[] getSituacoes() {
		return SituacaoEnum.values();
	}
	
}
	
