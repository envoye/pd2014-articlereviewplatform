/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Grauacademico;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBGrauAcademico")
@SessionScoped
public class MBGrauAcademico implements Serializable  {
    private String grauAcademico;
    
    private List<Grauacademico> listaGraus;
    private Grauacademico selectedGrau = new Grauacademico();
    private int grauId;
    
    /**
     * Creates a new instance of MBGrauAcademico
     */
    public MBGrauAcademico() {
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    public List<Grauacademico> getListaGraus() {
        if (listaGraus == null){
            listaGraus = (List<Grauacademico>)AllHellper.getListQualquerCoisa(Grauacademico.class);
        }                
        return listaGraus;
    }

    public void setListaGraus(List<Grauacademico> listaGraus) {
        this.listaGraus = listaGraus;
    }

    public Grauacademico getSelectedGrau() {
        if (this.selectedGrau.getId() == null) {
            this.selectedGrau = new Grauacademico("",null);
        }        
        return selectedGrau;
    }

    public void setSelectedGrau(Grauacademico selectedGrau) {
        this.selectedGrau = selectedGrau;
    }

    public int getGrauId() {
        return grauId;
    }

    public void setGrauId(int grauId) {
        this.grauId = grauId;
        for (int i=0;i<this.getListaGraus().size();i++){
            if (this.listaGraus.get(i).getId() == grauId){
                this.selectedGrau = this.listaGraus.get(i);
            }
        }                        
    }
    
    public String introduzir() {
        return "/model/investigadorAP/GrauAcademico.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        AllHellper.SaveQualquerCoisa(new Grauacademico(grauAcademico, null));
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }
    
    public String atualizar() {
        AllHellper.UpdateGrauAcademico(this.selectedGrau.getId(), this.selectedGrau.getGrauacademico());
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }        
    
    public String cancelarAct() {
        this.grauAcademico = "";
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        this.grauAcademico = "";
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }    
 
    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedGrau);
        this.selectedGrau = new Grauacademico("",null);
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }    
    
    public String pesquisar() {
        return "/model/investigadorAP/GrauAcademicoPesquisa.xhtml?faces-redirect=true";
    }    
    
    public String next() {
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }        
}