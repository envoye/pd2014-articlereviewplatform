/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import Email.SendEmail;
import HelpersHibernate.AllHellper;
import HibernatePackage.Investigador;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named(value = "mBRecuperarPassword")
@ViewScoped
public class MBRecuperarPassword {

   private String Email;
   private Investigador investigador; 

   
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
   public String recuperarPassword () {
        
        String condicao=(" as inv where inv.email='"+ Email+"'");

        investigador=(Investigador)AllHellper.getQualquerCoisaCondicao(Investigador.class,condicao);

        if (investigador!=null) {
            UUID uuid = UUID.randomUUID();
            String myRandom = uuid.toString().substring(0,10);
            String message= "A sua nova passWord será:" + myRandom;
            AllHellper.UpdatePassInvestigador(investigador.getId(), myRandom);
            SendEmail.sendEmail(message,investigador.getEmail());
            return "/model/investigador/LoginUtilizador.xhtml?faces-redirect=true";
        }
      
        FacesMessage msg = new FacesMessage("O email não existe!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "";
    }  
}
