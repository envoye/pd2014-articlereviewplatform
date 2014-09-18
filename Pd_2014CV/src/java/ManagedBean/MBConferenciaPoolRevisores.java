/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
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
@Named(value = "MBConferenciaPoolRevisores")
@SessionScoped
public class MBConferenciaPoolRevisores implements Serializable {
    private Conferenciaedicao conferenciaedicao;
    private Investigador investigador=new Investigador();
    private Byte classificacao;
    private String estado;
    private Date dataInicioConvite;
    private Date dataFimConvite;
    private Conferencia conferencia;
    private List<Investigador> listaInvestigadores;
    private List<Conferencia> listConferencias;
    private int idconferencia=0;
    private int idinvestigador=0;
     @Inject
    private LoginUtilizador loginUtilizador;

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
 
    

    public List<Conferencia> getListConferencias() {
        
       listConferencias=WorkingData.getTodasConferenciasAbertasInvestigadorComite(loginUtilizador.getInvestigador());
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }
    
  

    public Byte getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDataInicioConvite() {
        return dataInicioConvite;
    }

    public void setDataInicioConvite(Date dataInicioConvite) {
        this.dataInicioConvite = dataInicioConvite;
    }

    public Date getDataFimConvite() {
        return dataFimConvite;
    }

    public void setDataFimConvite(Date dataFimConvite) {
        this.dataFimConvite = dataFimConvite;
    }

    

    public List<Investigador> getListaInvestigadores() {
        
      listaInvestigadores=WorkingData.getListaAmigosNaoRevisores(conferenciaedicao, loginUtilizador.getInvestigador());
   return listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }

    public String introduzir() {
         
         if(idinvestigador==0)
            return"";
        for (Investigador inv : listaInvestigadores) {
             if(inv.getId()==idinvestigador){
               investigador=inv;
             break;
             }
            }      
        AllHellper.SaveQualquerCoisa(new Conferenciapoolrevisores(conferenciaedicao, this.investigador, this.classificacao, this.estado, this.dataInicioConvite, this.dataFimConvite, null));
       loginUtilizador.actualisaInvestigador();
        return "/model/conferencias/ConferenciaPoolRevisoresPesquisa.xhtml?faces-redirect=true";
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
        AllHellper.SaveQualquerCoisa(new Conferenciapoolrevisores(conferenciaedicao, this.investigador, this.classificacao, this.estado, this.dataInicioConvite, this.dataFimConvite, null));
       loginUtilizador.actualisaInvestigador();
        return "/model/conferencias/ConferenciaPoolRevisoresEdit.xhtml?faces-redirect=true";
    }
    
    public String cancelarAct() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        return "/model/conferencias/ConferenciaPoolRevisoresEdit.xhtml?faces-redirect=true";
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
         return "/model/conferencias/ConferenciaPoolRevisoresEdit.xhtml?faces-redirect=true";
            
        
     }
     
}
