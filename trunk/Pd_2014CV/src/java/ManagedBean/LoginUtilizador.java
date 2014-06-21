/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import java.io.Serializable;
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
@ViewScoped
public class LoginUtilizador {

    /**
     * Creates a new instance of LoginBean
     */
    
         private String username;
         private String password;

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
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
    try {
      //request.login(this.username, this.password);
      HttpSession s=request.getSession(true);
      s.setAttribute("username", this.username);
      s.setAttribute("password", this.password);
    } catch (Exception e) {
    
      //context.addMessage(null, new FacesMessage("Login failed."));
      return "ErrorYouMustLogon";
    }
    return "index";
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
    

