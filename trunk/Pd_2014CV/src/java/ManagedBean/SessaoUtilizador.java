/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos
 */
@Named(value = "sessaoUtilizador")
@SessionScoped
public class SessaoUtilizador implements Serializable {

    /**
     * Creates a new instance of SessaoUtilizador
     */
    public SessaoUtilizador() {
    }
    
}
