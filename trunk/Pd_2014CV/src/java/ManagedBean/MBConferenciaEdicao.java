/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Conferencia;
import HibernatePackage.Conferenciaedicao;
import HibernatePackage.Tema;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferenciaEdicao")
@ViewScoped
public class MBConferenciaEdicao {
    private String subNome;
    private String descricao;
    private Date data;
    private String local;
    private String edicao;
    private Date limiteSubmissao;
    private short maxArtigosRevisor;
    private short maxArtigos;
    private boolean configEncerrada;
    private Conferencia conferencia;
    private List<Conferencia> listConferencias; 
    private int idTema;
    private Tema temaEdicao;
    private List<Tema> listTemas; 
    private Conferenciaedicao confEdicao;
    
    /**
     * Creates a new instance of ConferenciaEdicao
     */
    public MBConferenciaEdicao() {
    }

    public String getSubNome() {
        return subNome;
    }

    public void setSubNome(String subNome) {
        this.subNome = subNome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Date getLimiteSubmissao() {
        return limiteSubmissao;
    }

    public void setLimiteSubmissao(Date limiteSubmissao) {
        this.limiteSubmissao = limiteSubmissao;
    }

    public short getMaxArtigosRevisor() {
        return maxArtigosRevisor;
    }

    public void setMaxArtigosRevisor(short maxArtigosRevisor) {
        this.maxArtigosRevisor = maxArtigosRevisor;
    }

    public short getMaxArtigos() {
        return maxArtigos;
    }

    public void setMaxArtigos(short maxArtigos) {
        this.maxArtigos = maxArtigos;
    }

    public boolean isConfigEncerrada() {
        return configEncerrada;
    }

    public void setConfigEncerrada(boolean configEncerrada) {
        this.configEncerrada = configEncerrada;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia() {
        for(int i=0;i<getListConferencias().size();i++){
            if(listTemas.get(i).getId().equals(this.conferencia.getId())){
                temaEdicao=listTemas.get(i);
            }
        }
    }

    public List<Conferencia> getListConferencias() {
        if(listConferencias == null){
            listConferencias = (List<Conferencia>)AllHellper.getListQualquerCoisa(Conferencia.class);
        }
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }
   
    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
        for(int i=0;i<getListTemas().size();i++){
            if(listTemas.get(i).getId()==idTema){
                temaEdicao=listTemas.get(i);
            }
        }
    }

    public Tema getTemaEdicao() {
        return temaEdicao;
    }

    public void setTemaEdicao(Tema temaEdicao) {
        this.temaEdicao = temaEdicao;
    }

    public List<Tema> getListTemas() {
        if(listTemas == null){
            listTemas = (List<Tema>)AllHellper.getListQualquerCoisa(Tema.class);
        }
        return listTemas;
    }

    public void setListTemas(List<Tema> listTemas) {
        this.listTemas = listTemas;
    }

    public Conferenciaedicao getConfEdicao() {
        return confEdicao;
    }

    public void setConfEdicao(Conferenciaedicao confEdicao) {
        this.confEdicao = confEdicao;
    }

    public String introduzir() {
        return "index";
    }
    
    public String gravar() {
        confEdicao = new Conferenciaedicao(temaEdicao, conferencia, subNome, descricao, data, local, edicao, limiteSubmissao, maxArtigosRevisor, maxArtigos, configEncerrada, null, null, null);
        AllHellper.SaveQualquerCoisa(this.confEdicao);
        return "index";
    }
    
    public String cancelar() {
        return "index";
    }

    public String pesquisar() {
        return "index";
    }
}
