/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Contacto;
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
@Named(value = "MBInvestigadorContacto")
@ViewScoped
public class MBInvestigadorContacto {
    private Investigador investigador=new Investigador();
    
    private List<Investigador> listaInvestigadores;
     @Inject
     private LoginUtilizador loginUtilizador;
	       
    /**
     * Creates a new instance of MBInvestigadorContacto
     */
    public MBInvestigadorContacto() {
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    public void setInvestigador() {
        for(int i=0;i<this.getListaInvestigadores().size();i++){
            if(this.listaInvestigadores.get(i).getId().equals(this.investigador.getId())){
                this.investigador = this.listaInvestigadores.get(i);
            }
        }        
    }


    public List<Investigador> getListaInvestigadores() {
        if(this.listaInvestigadores == null){
            this.listaInvestigadores = (List<Investigador>)AllHellper.getListQualquerCoisa(Investigador.class);
        Set<Contacto> Contactos=loginUtilizador.getInvestigador().getContactosForIdInvestigador();
            for (Contacto contactos : Contactos) {
               Investigador sub= contactos.getInvestigadorByInvestigadorContactId();
               int i=sub.getId();
               ArrayList<Investigador> s=new ArrayList<Investigador>();  
                for (Investigador invF : this.listaInvestigadores){
                    if(invF .getId()==i)
                        s.add(invF);
                 } 
                this.listaInvestigadores.removeAll(s);
            }
        } 
        int i=loginUtilizador.getInvestigador().getId();
        
        for (Investigador invF : this.listaInvestigadores){
                    if(invF .getId()==i){
                       this.listaInvestigadores.remove(invF);
                               break;
                 } 
        }
        
        return this.listaInvestigadores;
    }

    public void setListaInvestigadores(List<Investigador> listaInvestigadores) {
        this.listaInvestigadores = listaInvestigadores;
    }
    
    public String introduzir() {
        return  "/model/investigadorAP/InvestigadorContacto.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        
        AllHellper.SaveQualquerCoisa(new Contacto(loginUtilizador.getInvestigador(),investigador,0));
        return  "/model/investigadorAP/InvestigadorContacto.xhtml?faces-redirect=true";
    }
    
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String pesquisar() {
        return "index";
    }        
}
