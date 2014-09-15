/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Contacto;
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Valter
 */
@Named(value = "MBInvestigadorContacto")
@SessionScoped
public class MBInvestigadorContacto implements Serializable {
    private Investigador investigador=new Investigador();
    private List<Investigador> listaInvestigadores;
     @Inject
    private LoginUtilizador loginUtilizador;
     
    private List<Contacto> listaContactos;
    private List<Investigador> listaContactosPrivados;

    public List<Investigador> getListaContactosPrivados() {
        Investigador i=loginUtilizador.getInvestigador();
        this.listaContactosPrivados=WorkingData.GetContactosDoInvestigador(i);
       
        return listaContactosPrivados;
    }

    public void setListaContactosPrivados(List<Investigador> listaContactosPrivados) {
        
        this.listaContactosPrivados = listaContactosPrivados;
    }
    private Contacto selectedContacto = new Contacto();
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
                break;
            }
        }        
    }

    public List<Investigador> getListaInvestigadores() {
        
        Investigador i=loginUtilizador.getInvestigador();
        this.listaInvestigadores=WorkingData.getListaInvestigadoresNaoAmigos(i);
       
        
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
       loginUtilizador.actualisaInvestigador();
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

    public String eliminar() {
        AllHellper.DelQualquerCoisa(this.selectedContacto);
        this.selectedContacto = new Contacto();
        return "/model/investigadorAP/GrauAcademicoEdit.xhtml?faces-redirect=true";
    }            
    
    public String pesquisar() {
        return "/model/investigadorAP/InvestigadorContactoPesquisa.xhtml?faces-redirect=true";
    }        
    
    public String next() {
        return "/model/artigos/ItemRevisaoEdit.xhtml?faces-redirect=true";
    }            
}
