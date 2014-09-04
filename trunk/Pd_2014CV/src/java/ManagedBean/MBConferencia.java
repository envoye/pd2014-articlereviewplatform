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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBConferencia")
@ViewScoped
public class MBConferencia{
    private String nome;
    private String subNome;
    private String descricao;
    private Date data;
    private String local;
    private int edicao;
    private Date limiteSubmissao;
    private short maxArtigosRevisor;
    private short maxArtigos;
    private boolean configEncerrada;
    
    private List<Conferencia> listConferencias; 
    private Tema temaEdicao;
    private List<Tema> listTemas;
      @Inject
    private LoginUtilizador loginUtilizador;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
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

  

    public List<Conferencia> getListConferencias() {
        if(listConferencias == null){
            listConferencias = (List<Conferencia>)AllHellper.getListQualquerCoisa(Conferencia.class);
        }
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

    public Tema getTemaEdicao() {
        if(temaEdicao==null)
            temaEdicao=new Tema();
        return temaEdicao;
    }

    public void setTemaEdicao(Tema temaEdicao) {
        for(int i=0;i<getListTemas().size();i++){
            if(listTemas.get(i).getId().equals(this.temaEdicao.getId())){
                temaEdicao=listTemas.get(i);
            }
        }
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

    public String introduzir() {
        return "./model/conferencias/Conferencia.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        Conferencia conf=new Conferencia(loginUtilizador.getInvestigador(), nome);
        
        //conf.setConferenciaedicaos(confEd);
        
        AllHellper.SaveQualquerCoisa(conf);
         Set<Conferenciaedicao> confEd = new HashSet<Conferenciaedicao>();
        Conferenciaedicao conferenciaedicao=new Conferenciaedicao(temaEdicao, conf, subNome, descricao, data, local, edicao, limiteSubmissao, maxArtigosRevisor, maxArtigos, false, null, null, null);
        confEd.add(conferenciaedicao);
        AllHellper.SaveQualquerCoisa(conferenciaedicao);
        conf.setConferenciaedicaos(confEd);
        Set<Conferencia> c=loginUtilizador.getInvestigador().getConferencias();
        c.add(conf);
       loginUtilizador.getInvestigador().setConferencias(c);
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return  "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
        
    }

    public String pesquisar() {
        return "index";
    }    
}