/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Conferenciapoolrevisores;
import HibernatePackage.Investigador;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaPoolRevisores")
@ViewScoped
public class MBConferenciaPoolRevisores {
    private Conferenciaedicao conferenciaedicao;
    private Investigador investigador;
    private Byte classificacao;
    private String estado;
    private Date dataInicioConvite;
    private Date dataFimConvite;
    private List<Conferenciaedicao> listaEdicoes;
    private List<Investigador> listaInvestigadores;
    
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
        return "index";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Conferenciapoolrevisores(this.conferenciaedicao, this.investigador, this.classificacao, this.estado, this.dataInicioConvite, this.dataFimConvite, null));
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }    
}
