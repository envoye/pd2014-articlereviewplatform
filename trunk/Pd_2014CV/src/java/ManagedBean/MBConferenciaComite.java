/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaComite")
@SessionScoped
public class MBConferenciaComite implements Serializable {
    private Conferenciaedicao conferenciaedicao;
    private Investigador investigador=new Investigador();
    private boolean aceite;
    private List<Conferenciaedicao> listaEdicoes;
    private List<Conferencia> listConferencias;
    private List<Investigador> listaInvestigadores;
     @Inject
    private LoginUtilizador loginUtilizador;
    private Conferencia conferencia=new Conferencia();
    private int idconferencia=0;
    private int idinvestigador=0;
    
    public int getIdconferencia() {
        return idconferencia;
    }

    public void setIdconferencia(int idconferencia) {
        this.idconferencia = idconferencia;
    }

    public int getIdinvestigador() {
        return idinvestigador;
    }

    public void setIdinvestigador(int idinvestigador) {
        this.idinvestigador = idinvestigador;
    }
    
    /**
     * Creates a new instance of MBConferenciaComite
     */
    public MBConferenciaComite() {
    }
    
    /**
     * Creates a new instance of MBConferenciaComite
     * @return
     */
   

    

    public List<Conferencia> getListConferencias() {
      Investigador i= loginUtilizador.getInvestigador();
        listConferencias=WorkingData.getTodasConferenciasAbertasInvestigador(i);
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

    

    public Boolean isAceite() {
        return aceite;
    }

    public void setAceite(Boolean aceite) {
        this.aceite = aceite;
    }

    public List<Investigador> getListaInvestigadores() {
        Investigador i= loginUtilizador.getInvestigador();
       this.listaInvestigadores=WorkingData.getListaInvestigadoresConferenciaedicaoLivres(conferenciaedicao,i);
        return this.listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }
    
    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
       
         if(idinvestigador==0)
            return"";
        for (Investigador inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
             investigador=inv;
             break;
             }
            }
            AllHellper.SaveQualquerCoisa(new Conferenciacomite(conferenciaedicao, investigador, aceite, null));
            loginUtilizador.actualisaInvestigador();
        
                
            return "/model/conferencias/ConferenciaComite.xhtml?faces-redirect=true";
    }
    
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }
    
    public String next() {
        if(idconferencia==0)
            return"";
        for (Conferencia Edicoe : listConferencias) {
             if(Edicoe.getId()==idconferencia){
             conferencia=Edicoe;
             break;
             }
            }
            this.conferenciaedicao=WorkingData.getUltimaEdição(conferencia);
            return "/model/conferencias/ConferenciaComiteDois.xhtml?faces-redirect=true";
       
    }
}
