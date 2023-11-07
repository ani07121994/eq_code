package ap.quantas.com;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import model.APOperationAMImpl;

public class Utility {
    public Utility() {
        super();
    }

    public static APOperationAMImpl getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.APOperationAMDataControl.dataProvider}",
                                            Object.class);
        return (APOperationAMImpl)valueExp.getValue(elContext);
    }
    
    
    public static APOperationAMImpl getEbsAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.EbsAMDataControl.dataProvider}",
                                            Object.class);
        return (APOperationAMImpl)valueExp.getValue(elContext);
    }
    public static Object resolveExpression(String expression)
    {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
        elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }
    
    public static FacesContext getFacesContext()
    {
        return FacesContext.getCurrentInstance();
    }
}
