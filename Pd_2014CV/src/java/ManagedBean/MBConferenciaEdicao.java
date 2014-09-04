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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
    private int edicao;
    private Date limiteSubmissao;
    private short maxArtigosRevisor;
    private short maxArtigos;
    private boolean configEncerrada;
    private Conferencia conferencia=new Conferencia();
    private List<Conferencia> listConferencias; 
    private Tema temaEdicao=new Tema();
    private List<Tema> listTemas; 
      @Inject
    private LoginUtilizador loginUtilizador;
    /**
     * Creates a new instance of ConferenciaEdicao
     */
   
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

    public void setEdicao(String edicao) {
        int _edicao = 1;
        String condicao=(" where Conferenciaedicao.conferencia.id = '"+ this.conferencia.getId()+"'");        
        List<Conferenciaedicao> listaEdicoes = (List<Conferenciaedicao>)AllHellper.getListQualquerCoisaCondicao(Conferenciaedicao.class, condicao);
        for (int i=0; i<listaEdicoes.size(); i++) {
            if (_edicao < listaEdicoes.get(i).getEdicao()) {
                _edicao = listaEdicoes.get(i).getEdicao();
            }
        }
        this.edicao = _edicao;
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
            if(listConferencias.get(i).getId().equals(this.conferencia.getId())){
                this.conferencia=listConferencias.get(i);
            }
        }
    }

    public List<Conferencia> getListConferencias() {
        if(listConferencias == null){
            listConferencias=new ArrayList<Conferencia>();
            listConferencias.addAll( loginUtilizador.getInvestigador().getConferencias());
        }
        return listConferencias;
    }

    public void setListConferencias(List<Conferencia> listConferencias) {
        this.listConferencias = listConferencias;
    }

    public Tema getTemaEdicao() {
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
        return "/model/conferencias/ConferenciaEdicao.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        Conferenciaedicao confEd=new Conferenciaedicao(temaEdicao, conferencia, subNome, descricao, data, local, edicao, limiteSubmissao, maxArtigosRevisor, maxArtigos, false, null, null, null);
        AllHellper.SaveQualquerCoisa(confEd);
        for (Conferencia conferencia1 : loginUtilizador.getInvestigador().getConferencias()) {
            if(conferencia1.getId()==conferencia.getId()){
             conferencia1.getConferenciaedicaos().add(confEd);
             break;
            }
        }

         return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }
}
