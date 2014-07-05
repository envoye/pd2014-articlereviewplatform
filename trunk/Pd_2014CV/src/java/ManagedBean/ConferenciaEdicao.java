/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "ConferenciaEdicao")
@Dependent
public class ConferenciaEdicao {
    public String subNome;
    public String descricao;
    public Date data;
    public String local;
    public String edicao;
    public Date limiteSubmissao;
    public int maxArtigosRevisor;
    public int maxArtigos;
    public boolean configEncerrada;
    public int idConferencia;
    public int idTema;
    
    /**
     * Creates a new instance of ConferenciaEdicao
     */
    public ConferenciaEdicao() {
    }
    
    public void setSubNome(String subNome) {
        this.subNome = subNome;
    }
    
    public String getSubNome() {
        return this.subNome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public Date getData() {
        return this.data;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    
    public String getLocal() {
        return this.local;
    }    
    
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    
    public String getEdicao() {
        return this.edicao;
    }    
    
    public void setLimiteSubmissao(Date limiteSubmissao) {
        this.limiteSubmissao = limiteSubmissao;
    }
    
    public Date getLimiteSubmissao() {
        return this.limiteSubmissao;
    }    
    
    public void setMaxArtigosRevisor(int maxArtRevisor) {
        this.maxArtigosRevisor = maxArtRevisor;
    }
    
    public int getMaxArtigosRevisor() {
        return this.maxArtigosRevisor;
    }    
    
    public void setMaxArtigos(int maxArtigos) {
        this.maxArtigosRevisor = maxArtigos;
    }
    
    public int getMaxArtigos() {
        return this.maxArtigos;
    }    
    
    public void setConfiguracaoEncerrada(boolean configEncerrada) {
        this.configEncerrada = configEncerrada;
    }
    
    public boolean getConfiguracaoEncerrada() {
        return this.configEncerrada;
    }        
    
    public void setIdConferencia(int idConf) {
        this.idConferencia = idConf;
    }
    
    public int getIdConferencia() {
        return this.idConferencia;
    }        
    
    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }
    
    public int getIdTema() {
        return this.idTema;
    }            
    
    public String registar() {
        AllHellper.SaveQualquerCoisa(new ConferenciaEdicao());
        return "index";
    }
}
