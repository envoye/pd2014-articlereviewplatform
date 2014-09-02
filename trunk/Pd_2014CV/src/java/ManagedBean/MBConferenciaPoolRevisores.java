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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Named(value = "MBConferenciaPoolRevisores")
@SessionScoped
public class MBConferenciaPoolRevisores implements Serializable {
    private Conferenciaedicao conferenciaedicao;
    private Investigador investigador=new Investigador();
    private Byte classificacao;
    private String estado;
    private Date dataInicioConvite;
    private Date dataFimConvite;
    private List<Conferenciaedicao> listaEdicoes;
    private List<Investigador> listaInvestigadores;
     private List<Conferencia> listConferencias;
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
      @Inject
    private LoginUtilizador loginUtilizador;
    private Conferencia conferencia=new Conferencia();
    /**
     * Creates a new instance of MBConferenciaPoolRevisores
     */
    public MBConferenciaPoolRevisores() {
    }

    public Conferenciaedicao getConferenciaedicao() {
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
        return investigador;
    }

    public void setInvestigador(Investigador investigador) {
        for(int i=0;i<this.getListaInvestigadores().size();i++){
            if(this.listaInvestigadores.get(i).getId().equals(this.investigador.getId())){
                this.investigador = this.listaInvestigadores.get(i);
            }
        }
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

    public List<Conferenciaedicao> getListaEdicoes() {
        if(this.listaEdicoes == null){
            this.listaEdicoes = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisa(Conferenciaedicao.class);
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
        return "/model/conferencias/ConferenciaPoolRevisores.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        for(int i=0;i<getListConferencias().size();i++){
            if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
                this.conferencia=listConferencias.get(i);
            }}
        setInvestigador(this.investigador);
        Conferenciaedicao confEd=new Conferenciaedicao();
                confEd.setId(0);
                for (Iterator<Conferenciaedicao> it1 = this.conferencia.getConferenciaedicaos().iterator(); it1.hasNext();) {
                    Conferenciaedicao conferenciaedicao1 = it1.next();
                    if(conferenciaedicao1.getId() >confEd.getId())
                    confEd=conferenciaedicao1;
                }
                if(confEd!=null)
        AllHellper.SaveQualquerCoisa(new Conferenciapoolrevisores(confEd, this.investigador, this.classificacao, this.estado, this.dataInicioConvite, this.dataFimConvite, null));
        return "/model/conferencias/ConferenciaPoolRevisores.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    } 
    
     public String next() {
        if(conferencia.getId()>=0)
            return "/model/conferencias/ConferenciaPoolRevisoresDois.xhtml?faces-redirect=true";
        else
            return "";
    }
}
