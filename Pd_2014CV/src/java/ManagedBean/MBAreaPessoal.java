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
        
        if (this.listaGC == null){
            String condicao = "inner join conferencia on conferencia.`Id` = conferenciaedicao.`idConferencia` " 
                    + "where conferencia.Investigador_Id = '" + i.getId() + "' and data >= curdate();";
            this.listaGC = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class,condicao);
        }                
        return listaGC;
    }

    public void setListaGC(List<Conferenciaedicao> ListaGC) {
        this.listaGC = ListaGC;
    }

    public List<Conferenciaedicao> getListaEC() {
        if (this.listaEC == null){
            String condicao = " inner join conferenciacomite on conferenciaedicao.`Id` = conferenciacomite.`idConferenciaEdicao` " 
                    + "inner join investigador on investigador.`Id` = conferenciacomite.`idInvestigador` " 
                    + "where investigador.username = '" + this.loginUtilizador.getUsername() + "' "
                    + "and data >= curdate();";
            
            this.listaEC = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class,condicao);
        }                        
        return listaEC;
    }

    public void setListaEC(List<Conferenciaedicao> listaEC) {
        this.listaEC = listaEC;
    }

    public List<Conferenciaedicao> getListaRev() {
        if (this.listaRev == null){
            String condicao = " inner join conferenciapoolrevisores on conferenciaedicao.`Id` = conferenciapoolrevisores.`idConferenciaEdicao` " 
                    + "inner join investigador on investigador.`Id` = conferenciapoolrevisores.`idInvestigador` " 
                    + "where investigador.username = '" + this.loginUtilizador.getUsername() + "' "
                    + "and data >= curdate();";
            
            this.listaRev = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class,condicao);
        }                        
        return listaRev;
    }

    public void setListaRev(List<Conferenciaedicao> listaRev) {
        this.listaRev = listaRev;
    }
    
}
