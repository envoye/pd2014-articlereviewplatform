/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Valter
 */
@Named(value = "temasConferencias")
@Dependent
public class TemasConferencias {

    /**
     * Creates a new instance of TemaConferencia
     */
    public TemasConferencias() {
    }
    
}
