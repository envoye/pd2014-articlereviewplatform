/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Carlos
 */
@WebService(serviceName = "ConferenciasWebService")
@Stateless()
public class ConferenciasWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getNumeroArtigos")
    //@WebParam(name = "name") String txt
    public int getNumeroArtigos() {
        ArrayList<Artigo> i= (ArrayList<Artigo>)AllHellper.getListQualquerCoisa(Artigo.class);
        return i.size();
    }
    @WebMethod(operationName = "getDiasRestantesByName")
    public String getDiasRestantesByName(@WebParam(name = "name") String name) {
        
        return WorkingData.getDiasFimConferencia(name);
    }
     @WebMethod(operationName = "getDiasRestantesById")
    public String getDiasRestantesById(@WebParam(name = "id") int id) {
       
        return WorkingData.getDiasFimConferencia(id);
    }
}
