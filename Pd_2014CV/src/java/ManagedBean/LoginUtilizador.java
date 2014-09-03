/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import Email.SendEmail;
import HelpersHibernate.AllHellper;
import HibernatePackage.Investigador;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Carlos
 */
@Named(value = "auth")
@SessionScoped
public class LoginUtilizador implements Serializable {

    private static final long serialVersionUID = 7765876811740798583L;
    private String username;
    private String password;
    private boolean loggedIn;
    private Investigador investigador; 

    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login () {
        
        String condicao=(" as inv where inv.utilizador='"+ username+"' and inv.password='" +password+"'");

        investigador=(Investigador)AllHellper.getQualquerCoisaCondicao(Investigador.class,condicao);

        if (investigador!=null&& password.equals(investigador.getPassword())&& username.equals(investigador.getUtilizador())) {
            loggedIn = true;
            return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
        }
      
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            return "/model/principais/PaginaPrincipal.xhtml?faces-redirect=true";
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
            return "";
        }
    }
}