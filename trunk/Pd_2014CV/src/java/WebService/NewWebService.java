/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Investigador;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public ArrayList<Investigador> hello(@WebParam(name = "name") String txt) {
       ArrayList<Investigador> i= (ArrayList<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
        return i;
    }
}
