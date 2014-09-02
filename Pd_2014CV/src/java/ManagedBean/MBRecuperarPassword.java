/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Carlos
 */
@Named(value = "mBRecuperarPassword")
@ViewScoped
public class MBRecuperarPassword {

   private String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
