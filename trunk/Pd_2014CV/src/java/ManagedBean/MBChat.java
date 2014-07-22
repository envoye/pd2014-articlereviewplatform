/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HibernatePackage.Conferenciacomiteartigoforum;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */
@Named(value = "mBChat")
@ViewScoped
public class MBChat {
private Conferenciacomiteartigoforum forum; 
    /**
     * Creates a new instance of MBChat
     */
    public MBChat() {
    }
    
}
