/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBAreaPessoal")
@SessionScoped
public class MBAreaPessoal implements Serializable {
    private List<Conferenciaedicao> listaGC;
    private List<Conferenciaedicao> listaEC;
    private List<Conferenciaedicao> listaRev;
    @Inject
    private LoginUtilizador loginUtilizador;
      
    
    /**
     * Creates a new instance of MBAreaPessoal
     */
    public MBAreaPessoal() {
    }

    public List<Conferenciaedicao> getListaGC() {
        Investigador i=loginUtilizador.getInvestigador();
        listaGC=TrabalharDados.WorkingData.getTodasEdicaosConferenciasAbertasInvestigador(i);
              
        return listaGC;
    }

    public void setListaGC(List<Conferenciaedicao> ListaGC) {
        this.listaGC = ListaGC;
    }

    public List<Conferenciaedicao> getListaEC() {
       
          Investigador i=loginUtilizador.getInvestigador();
            
            this.listaEC = TrabalharDados.WorkingData.getTodasEdicoesConferenciasAbertasInvestigadorComite(i);
                              
        return listaEC;
    }

    public void setListaEC(List<Conferenciaedicao> listaEC) {
        this.listaEC = listaEC;
    }

    public List<Conferenciaedicao> getListaRev() {
       Investigador i=loginUtilizador.getInvestigador();
       listaRev=TrabalharDados.WorkingData.getTodasEdicoesConferenciasAbertasInvestigadorRevisores(i);
        return listaRev;
    }

    public void setListaRev(List<Conferenciaedicao> listaRev) {
        this.listaRev = listaRev;
    }
    
}
