/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Grauacademico;
import HibernatePackage.Investigador;
import TrabalharDados.WorkingData;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Valter
 */
@Named(value = "MBInvestigadorDadosPessoais")
@SessionScoped
public class MBInvestigadorDadosPessoais implements Serializable {

    private Grauacademico grauacademico;
     @Size(min = 3, max = 60,message = "Por favor intruduza um nome com pelo menos 3 caracteres.")
    private String nome;
     @Size(min = 2, max = 60,message ="Por favor intruduza um nome com pelo menos 2 caracteres.")
    private String instituicao;
    private Date datanascimento;
     @Size(min = 6, max = 60,message = "Por favor intruduza um nome com pelo menos 5 caracteres.")
    private String utilizador;
     @Size(min = 6, max = 60,message = "Password terá de ter pelo menos 3 caracteres.")
    private String password;
     @Email(message = "Email formato terá de ter o formato (xxx@xxx.xxx)")
    private String email;
     @Pattern(regexp = "^((\\+|0)351)?2\\d{8}$", message = "Formato de telefone desconhecido.")
    private String telefone;
     @Pattern(regexp = "^((\\+|0)351)?9\\d{8}$", message = "Formato de telemovel desconhecido.")
    private String telemovel;
     @Size(min = 6, max = 60,message = "Password terá de ter 6 caracteres.")
    private String oldpassconf;
     @Size(min = 6, max = 60,message = "Password terá de ter 6 caracteres.")
    private String newpassword;
     @Size(min = 6, max = 60,message = "Password terá de ter 6 caracteres.")
    private String passwordconf;
    private int idGrauacademico;
    private List<Grauacademico> listGrauacademico; 
     @Inject
    private LoginUtilizador loginUtilizador;    

    /**
     * Creates a new instance of MBInvestigadorDadosPessoais
     */
    public MBInvestigadorDadosPessoais() {
    }
     
    public int getIdGrauacademico() {
        this.idGrauacademico = loginUtilizador.getInvestigador().getGrauacademico().getId();
        return idGrauacademico;
    }

    public void setIdGrauacademico(int idGrauacademico) {
        this.idGrauacademico = idGrauacademico;
        for (int i=0;i<getListGrauacademico().size();i++){
            if (listGrauacademico.get(i).getId()==idGrauacademico){
                this.grauacademico=listGrauacademico.get(i);
            }
        }
    }

    public List<Grauacademico> getListGrauacademico() {
        if (listGrauacademico == null){
            listGrauacademico = (List<Grauacademico>)AllHellper.getListQualquerCoisa(Grauacademico.class);
        }
        return listGrauacademico;
    }

    public void setListGrauacademico(List<Grauacademico> listGrauacademico) {
        this.listGrauacademico = listGrauacademico;
    }

    public String getOldpassconf() {
        return oldpassconf;
    }

    public void setOldpassconf(String oldpassconf) {
        this.oldpassconf = oldpassconf;
    }
   
    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    
    public void setPasswordconf(String passwordconf) {
        this.passwordconf = passwordconf;
    }

    public String getPasswordconf() {
        return passwordconf;
    }
     
    public Grauacademico getGrauacademico() {
        if(grauacademico==null)
            if(getListGrauacademico().size()>0)
            grauacademico=listGrauacademico.get(0);
        return grauacademico;
    }

    public String getNome() {
        this.nome = loginUtilizador.getInvestigador().getNome();
        return nome;
    }

    public String getInstituicao() {
        this.instituicao = loginUtilizador.getInvestigador().getInstituicao();
        return instituicao;
    }

    public Date getDatanascimento() {
        this.datanascimento = loginUtilizador.getInvestigador().getDatanascimento();
        return datanascimento;
    }

    public String getUtilizador() {
        this.utilizador = loginUtilizador.getInvestigador().getUtilizador();
        return utilizador;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        this.email = loginUtilizador.getInvestigador().getEmail();
        return email;
    }

    public String getTelefone() {
        this.telefone = loginUtilizador.getInvestigador().getTelefone();
        return telefone;
    }

    public String getTelemovel() {
        this.telemovel = loginUtilizador.getInvestigador().getTelemovel();        
        return telemovel;
    }

    public void setGrauacademico(Grauacademico grauacademico) {
        this.grauacademico = grauacademico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
         
    }
    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }
     
    public String atualizar() {
       Investigador i=loginUtilizador.getInvestigador();
        if(i.getPassword().equals(password)){
              if(!WorkingData.utilizadorJaExiste(utilizador,email)){
            loginUtilizador.setInvestigador(AllHellper.UpdateInvestigador(loginUtilizador.getInvestigador().getId(),grauacademico, nome, instituicao, datanascimento, utilizador, email, telefone, telemovel));
            return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
              }
              FacesMessage msg = new FacesMessage("Email ou utilizador já utilizados!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
              
        }
        FacesMessage msg = new FacesMessage("Erro passWord invalida!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
    }
      public String atualizarPassWord() {
        loginUtilizador.setInvestigador(AllHellper.UpdatePassInvestigador(loginUtilizador.getInvestigador().getId(), newpassword));
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
    public String cancelar() {
        return "/model/principais/AreaPessoal.xhtml?faces-redirect=true";
    }
}