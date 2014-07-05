/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Investigador;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginUtilizador implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    private static final long serialVersionUID = 7765876811740798583L;
    private String username;
    private String password;
    private boolean loggedIn;

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
      Investigador investigador; 
      
       String condicao=(" as inv where inv.utilizador='"+ username+"' and inv.password='" +password+"'");
      
       investigador=(Investigador)AllHellper.getQualquerCoisaCondicao(Investigador.class,condicao);
       if (investigador!=null&& password.equals(investigador.getPassword())&& username.equals(investigador.getUtilizador())) {
        
                loggedIn = true;
                return "/index.xhtml?faces-redirect=true";
            }

      
      
     FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);

   return"";
  }

  public void logout() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
    try {
      request.logout();
    } catch (ServletException e) {
      context.addMessage(null, new FacesMessage("Logout failed."));
    }
  }
    }
    

