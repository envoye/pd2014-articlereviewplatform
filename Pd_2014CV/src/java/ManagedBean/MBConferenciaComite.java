/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciacomite;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Investigador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
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
     private Investigador investigador;
     private boolean aceite;
     private List<Conferenciaedicao> listaEdicoes;
     private List<Investigador> listaInvestigadores;
      @Inject
    private LoginUtilizador loginUtilizador;
    /**
     * Creates a new instance of MBConferenciaComite
     */
    public MBConferenciaComite() {
    }

    public Conferenciaedicao getConferenciaedicao() {
        if(conferenciaedicao==null)
          conferenciaedicao=new Conferenciaedicao();
        return conferenciaedicao;
    }

    public void setConferenciaedicao(Conferenciaedicao conferenciaedicao) {
        for(int i=0;i<this.getListaEdicoes().size();i++){
            if(this.listaEdicoes.get(i).getId().equals(this.conferenciaedicao.getId())){
                this.conferenciaedicao = this.listaEdicoes.get(i);
            }
        }        
    }

    public Investigador getInvestigador() {
        if(investigador==null)
          investigador=new Investigador();
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        for(int i=0;i<this.getListaInvestigadores().size();i++){
            if(this.listaInvestigadores.get(i).getId().equals(this.investigador.getId())){
                this.investigador = this.listaInvestigadores.get(i);
            }
        }
    }

    public Boolean isAceite() {
        return aceite;
    }

    public void setAceite(Boolean aceite) {
        this.aceite = aceite;
    }

    public List<Conferenciaedicao> getListaEdicoes() {
        
            //this.listaEdicoes = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisa(Conferenciaedicao.class);
        this.listaEdicoes=new ArrayList<Conferenciaedicao>();
            Set<Conferencia> conf=loginUtilizador.getInvestigador().getConferencias();
            for (Iterator<Conferencia> it = conf.iterator(); it.hasNext();) {
                Conferencia conferencia = it.next();
                Set<Conferenciaedicao> edit= conferencia.getConferenciaedicaos();
                Conferenciaedicao confEd=new Conferenciaedicao();
                confEd.setId(0);
                for (Iterator<Conferenciaedicao> it1 = edit.iterator(); it1.hasNext();) {
                    Conferenciaedicao conferenciaedicao1 = it1.next();
                    if(conferenciaedicao1.getId() >confEd.getId())
                    confEd=conferenciaedicao1;
                }
                if(confEd!=null){
                 this.listaEdicoes.add(confEd);
                         }
            
            
        }        
        return this.listaEdicoes;
    }

    public void setListaEdicoes(List<Conferenciaedicao> listaEdicoes) {
        this.listaEdicoes = listaEdicoes;
    }

    public List<Investigador> getListaInvestigadores() {
        if(this.listaInvestigadores == null){
            this.listaInvestigadores = (List<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
        }                
        return this.listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }
    
    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferenciacomite(conferenciaedicao, investigador, aceite, null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }
    
    public String next() {
        if(conferenciaedicao!=null)
            return "/model/conferencias/ConferenciaComiteDois.xhtml?faces-redirect=true";
        else
            return "";
    }
}
