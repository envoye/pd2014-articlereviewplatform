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

    /**
     * Creates a new instance of MBConferenciaComite
     */
    public MBConferenciaComite() {
    }
    
    /**
     * Creates a new instance of MBConferenciaComite
     * @return
     */
    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia() {
        for(int i=0;i<getListConferencias().size();i++){
            if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
                this.conferencia=listConferencias.get(i);
            }
        }
    }

    public List<Conferencia> getListConferencias() {
        if(listConferencias == null || listConferencias.size()==0 ){
        listConferencias=new ArrayList<Conferencia>();
            Set<Conferencia> conf=loginUtilizador.getInvestigador().getConferencias();
        
            listConferencias .addAll(conf);
        }
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
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
        this.listaEdicoes = new ArrayList<Conferenciaedicao>();
        Set<Conferencia> conf = loginUtilizador.getInvestigador().getConferencias();
        for (Iterator<Conferencia> it = conf.iterator(); it.hasNext();) {
            Conferencia conferencia = it.next();
            Set<Conferenciaedicao> edit = conferencia.getConferenciaedicaos();
            Conferenciaedicao confEd = new Conferenciaedicao();
            confEd.setId(0);
            for (Iterator<Conferenciaedicao> it1 = edit.iterator(); it1.hasNext();) {
                Conferenciaedicao conferenciaedicao1 = it1.next();
                if(conferenciaedicao1.getId() > confEd.getId())
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
        for(int i = 0;i < getListConferencias().size();i++){
           if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
               this.conferencia=listConferencias.get(i);
           }
        }
        Conferenciaedicao confEd = new Conferenciaedicao();
        confEd.setId(0);
        for (Iterator<Conferenciaedicao> it1 = this.conferencia.getConferenciaedicaos().iterator(); it1.hasNext();) {
            Conferenciaedicao conferenciaedicao1 = it1.next();
            if(conferenciaedicao1.getId() >confEd.getId())
                confEd=conferenciaedicao1;
        }
        if(confEd!=null)
            AllHellper.SaveQualquerCoisa(new Conferenciacomite(confEd, investigador, aceite, null));
        return "/model/conferencias/ConferenciaComite.xhtml?faces-redirect=true";
    }
    
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }
    
    public String next() {
        if(conferencia.getId()>=0)
            return "/model/conferencias/ConferenciaComiteDois.xhtml?faces-redirect=true";
        else
            return "";
    }
}
