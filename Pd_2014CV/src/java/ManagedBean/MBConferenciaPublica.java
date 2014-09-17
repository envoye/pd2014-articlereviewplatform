/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigorevisao;
import HibernatePackage.Conferenciacomiteartigo;
import HibernatePackage.Conferenciaedicao;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaPublica")
@Dependent
public class MBConferenciaPublica {
    private List<Conferenciaedicao> listaConfRealiz;
    private List<Conferenciaedicao> listaConfFuturas;
    
    private List<Conferenciacomiteartigo> listaTopArtigos;
    /**
     * Creates a new instance of MBConferenciaPublica
     */
    public MBConferenciaPublica() {
    }
 
    public List<Conferenciaedicao> getListaConfRealiz() {
        listaConfRealiz = TrabalharDados.WorkingData.getListEdicoesPassadas();
        return listaConfRealiz;
    }

    public void setListaConfRealiz(List<Conferenciaedicao> listaConfRealiz) {
        this.listaConfRealiz = listaConfRealiz;
    }

    public List<Conferenciaedicao> getListaConfFuturas() {
        listaConfFuturas = TrabalharDados.WorkingData.getListEdicoesFuturas();
        return listaConfFuturas;
    }

    public void setListaConfFuturas(List<Conferenciaedicao> listaConfFuturas) {
        this.listaConfFuturas = listaConfFuturas;
    }

    public List<Conferenciacomiteartigo> getListaTopArtigos() {
        listaTopArtigos = TrabalharDados.WorkingData.getListaTopArtigos();
        return listaTopArtigos;
    }

    public void setListaTopArtigos(List<Conferenciacomiteartigo> listaTopArtigos) {
        this.listaTopArtigos = listaTopArtigos;
    }
    
    
}
