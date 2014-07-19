/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Grauacademico;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "investigadorGrauAcademico")
@Dependent
public class InvestigadorGrauAcademico {

    /**
     * Creates a new instance of InvestigadorGrauAcademico
     */
    public InvestigadorGrauAcademico() {
    }
    
}
