package br.com.esig.converter;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

 
import br.com.esig.model.UsuarioPessoa;
import br.com.managedBean.TarefaBean;

@FacesConverter(value = "usuarioPessoaConverter")
public class UsuarioPessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String id) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{tarefaBean}", TarefaBean.class);

        TarefaBean tarefa = (TarefaBean)vex.getValue(ctx.getELContext());
        return tarefa.getUsuarioPessoa(Long.valueOf(id));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object pessoa) {
        return ((UsuarioPessoa)pessoa).getId().toString();
    }

}