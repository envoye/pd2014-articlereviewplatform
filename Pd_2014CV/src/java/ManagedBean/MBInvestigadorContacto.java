/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Contacto;
import HibernatePackage.Investigador;
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
     
    private List<Contacto> listaContactos;
    private Contacto selectedContacto;
    private int contactoId;
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

    public List<Contacto> getListaContactos() {
        if (listaContactos == null){
            listaContactos = (List<Contacto>)AllHellper.getListQualquerCoisa(Contacto.class);
        }                                
        return listaContactos;
    }

    public void setListaContactos(List<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public Contacto getSelectedContacto() {
        if (this.selectedContacto.getId() == null) {
            this.selectedContacto = new Contacto();
        }                        
        return selectedContacto;
    }

    public void setSelectedContacto(Contacto selectedContacto) {
        this.selectedContacto = selectedContacto;
    }

    public int getContactoId() {
        return contactoId;
    }

    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
        for (int i=0;i<this.getListaContactos().size();i++){
            if (this.listaContactos.get(i).getId() == contactoId){
                this.selectedContacto = this.listaContactos.get(i);
            }
        }                                        
    }
   
    public String introduzir() {
        return "/model/investigadorAP/InvestigadorContacto.xhtml?faces-redirect=true";
    }
    
    public String gravar() {
        Contacto contacto=new Contacto(investigador,loginUtilizador.getInvestigador(),0);
        AllHellper.SaveQualquerCoisa(contacto);
       loginUtilizador.getInvestigador().getContactosForIdInvestigador().add(contacto);
        return "/model/investigadorAP/InvestigadorContactoEdit.xhtml?faces-redirect=true";
    }

    public String atualizar() {
        AllHellper.UpdateContacto(this.selectedContacto.getId(), this.selectedContacto.getInvestigadorByIdInvestigador(), this.selectedContacto.getInvestigadorByInvestigadorContactId(), this.selectedContacto.getIdContacto());
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }                    
    
    public String cancelarAct() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }

    public String cancelarIntro() {
        return "/model/investigadorAP/InvestigadorContactoEdit.xhtml?faces-redirect=true";
    }    
    
    public String pesquisar() {
        return "/model/investigadorAP/InvestigadorContactoPesquisa.xhtml?faces-redirect=true";
    }        
    
    public String next() {
        if(this.selectedContacto.getId() == null) {
            return "";
        }
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }            
}
