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
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Carlos
 */
@Named(value = "RegistoUtilizador")
@ViewScoped
public class RegistoUtilizador {
    private Grauacademico grauacademico;
     @Size(min = 3, max = 60,message = "Por favor intruduza um nome com pelo menos 3 caracteres.")
    private String nome;
     @Size(min = 2, max = 60,message ="Por favor intruduza um nome com pelo menos 2 caracteres.")
    private String instituicao;
    private Date datanascimento;
     @Size(min = 3, max = 60,message = "Por favor intruduza um nome com pelo menos 5 caracteres.")
    private String utilizador;
     @Size(min = 6, max = 60,message = "Password terá de ter pelo menos 6 caracteres.")
    private String password;
     @Email(message = "Email formato terá de ter o formato (xxx@xxx.xxx)")
    private String email;
     @Pattern(regexp = "^((\\+|0)351)?2\\d{8}$", message = "Formato de telefone desconhecido.")
    private String telefone;
     @Pattern(regexp = "^((\\+|0)351)?9\\d{8}$", message = "Formato de telemovel desconhecido.")
    private String telemovel;
     @Size(min = 6, max = 60,message = "Password terá de ter 6 caracteres.")
    private String passwordconf;
    private int idGrauacademico;
    private List<Grauacademico> listGrauacademico; 
     
    public int getIdGrauacademico() {
        return idGrauacademico;
    }

    public void setIdGrauacademico(int idGrauacademico) {
        this.idGrauacademico = idGrauacademico;
        for (int i=0;i<getListGrauacademico().size();i++){
            if (listGrauacademico.get(i).getId()==idGrauacademico){
                grauacademico=listGrauacademico.get(i);
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
        return nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTelemovel() {
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
     
    public String registar () {
        if(!WorkingData.utilizadorJaExiste(utilizador,email)){
        AllHellper.SaveQualquerCoisa(new Investigador(grauacademico, nome, instituicao, datanascimento, utilizador, password, email, telefone, telemovel, null, null, null, null, null, null,null,null));
        return "/model/investigador/LoginUtilizador.xhtml?faces-redirect=true";}
        return"";
    }
    
    public String cancelar() {
        return "/model/principais/PaginaPrincipal.xhtml?faces-redirect=true";
    }
    
}
