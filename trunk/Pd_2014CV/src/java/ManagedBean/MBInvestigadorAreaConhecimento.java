/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Investigador;
import HibernatePackage.Investigadorareaconhecimento;
import HibernatePackage.Subtema;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBInvestigadorAreaConhecimento")
@ViewScoped
public class MBInvestigadorAreaConhecimento {
    private Subtema subtema=new Subtema();
//    private Investigador investigador = new Investigador();
    private Byte grauConfianca;
    private Byte preferencia;
    private List<Subtema> listaSubtemas;
    private List<Investigador> listaInvestigadores;
    @Inject
    private LoginUtilizador loginUtilizador;
     
    private List<Investigadorareaconhecimento> listaAreas;
    private Investigadorareaconhecimento selectedArea;
    private int areaId;
     
    /**
     * Creates a new instance of MBInvestigadorAreaConhecimento
     */
    public MBInvestigadorAreaConhecimento() {
    }

    public Subtema getSubtema() {
        return subtema;
    }

    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }

//    public Investigador getInvestigador() {
//        return investigador;
//    }
//
//    public void setInvestigador(Investigador investigador) {
//        for(int i=0;i<this.getListaInvestigadores().size();i++){
//            if(this.listaInvestigadores.get(i).getId().equals(this.investigador.getId())){
//                this.investigador = this.listaInvestigadores.get(i);
//            }
//        }        
//    }

    public Byte getGrauConfianca() {
        return grauConfianca;
    }

    public void setGrauConfianca(Byte grauConfianca) {
        this.grauConfianca = grauConfianca;
    }

    public Byte getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Byte preferencia) {
        this.preferencia = preferencia;
    }

    public List<Subtema> getListaSubtemas() {
        if(this.listaSubtemas == null){
            this.listaSubtemas = (List<Subtema>)AllHellper.getListQualquerCoisa(Subtema.class);
            Set<Investigadorareaconhecimento> investigadorareaconhecimentos=loginUtilizador.getInvestigador().getInvestigadorareaconhecimentos();
            for (Investigadorareaconhecimento investigadorareaconhecimento : investigadorareaconhecimentos) {
               Subtema sub= investigadorareaconhecimento.getSubtema();
               int i=sub.getId();
               ArrayList<Subtema> s=new ArrayList<Subtema>();  
                for (Subtema subF : this.listaSubtemas){
                    if(subF .getId()==i)
                        s.add(subF);
                 } 
                this.listaSubtemas.removeAll(s);
            }
            
        }                        
        return listaSubtemas;
    }

    public void setListaSubtemas(List<Subtema> listaSubtemas) {
        this.listaSubtemas = listaSubtemas;
    }
    
    public List<Investigador> getListaInvestigadores() {
        if(this.listaInvestigadores == null){
            this.listaInvestigadores = (List<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
        }                
        return listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }

    public LoginUtilizador getLoginUtilizador() {
        return loginUtilizador;
    }

    public void setLoginUtilizador(LoginUtilizador loginUtilizador) {
        this.loginUtilizador = loginUtilizador;
    }

    public List<Investigadorareaconhecimento> getListaAreas() {
        if (listaAreas == null){
            listaAreas = (List<Investigadorareaconhecimento>)AllHellper.getListQualquerCoisa(Investigadorareaconhecimento.class);
        }                        
        return listaAreas;
    }

    public void setListaAreas(List<Investigadorareaconhecimento> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public Investigadorareaconhecimento getSelectedArea() {
        if (this.selectedArea.getId() == null) {
            this.selectedArea = new Investigadorareaconhecimento();
        }                        
        return selectedArea;
    }

    public void setSelectedArea(Investigadorareaconhecimento selectedArea) {
        this.selectedArea = selectedArea;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
        for (int i=0;i<this.getListaAreas().size();i++){
            if (this.listaAreas.get(i).getId() == areaId){
                this.selectedArea = this.listaAreas.get(i);
            }
        }                                        
    }
    
    public String introduzir() {
        return "/model/investigadorAP/InvestigadorAreaConhecimento.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        Investigadorareaconhecimento investigadorareaconhecimento=new Investigadorareaconhecimento(subtema, loginUtilizador.getInvestigador(), grauConfianca, preferencia);
        AllHellper.SaveQualquerCoisa(investigadorareaconhecimento);
        loginUtilizador.getInvestigador().getInvestigadorareaconhecimentos().add(investigadorareaconhecimento);
        return "/model/investigadorAP/InvestigadorAreaConhecimento.xhtml?faces-redirect=true";
    }

    public String atualizar() {
        AllHellper.UpdateAreaConhecimento(this.selectedArea.getId(), this.selectedArea.getSubtema(), null, this.selectedArea.getGrauConfianca(), this.selectedArea.getPreferencia());
        return "/model/investigadorAP/InvestigadorAreaConhecimentoEdit.xhtml?faces-redirect=true";
    }                    
    
    public String cancelarAct() {
        this.subtema = new Subtema();
        this.grauConfianca = 0;
        this.preferencia = 0;
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        this.subtema = new Subtema();
        this.grauConfianca = 0;
        this.preferencia = 0;        
        return "/model/investigadorAP/InvestigadorAreaConhecimentoEdit.xhtml?faces-redirect=true";
    }        

    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedArea);
        this.selectedArea = new Investigadorareaconhecimento();
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }            
    
    public String pesquisar() {
        return "/model/investigadorAP/InvestigadorAreaConhecimentoPesquisa.xhtml?faces-redirect=true";
    }            
    
    public String next() {
        return "/model/investigadorAP/InvestigadorAreaConhecimentoEdit.xhtml?faces-redirect=true";
    }        
    
}
