/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Investigador;
import HibernatePackage.Subtema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Carlos
 */
@Named(value = "artigoRegisto")
@ViewScoped
public class ArtigoRegisto {

    /**
     * Creates a new instance of ArtigoRegisto
     */
    public ArtigoRegisto() {
    }
     private Subtema subtema;
     private String titulo;
     private String resumo;
     private Date data;
     private String link;
     private Part ficheiroPdf;
     private int idSubtema;
     private List<Subtema> listSubtema; 

    public int getIdSubtema() {
        return idSubtema;
    }

    public void setIdSubtema(int idSubtema) {
        this.idSubtema = idSubtema;
    }

    public List<Subtema> getListSubtema() {
        return listSubtema;
    }

    public void setListSubtema(List<Subtema> listSubtema) {
        this.listSubtema = listSubtema;
    }
     
     
    public Subtema getSubtema() {
        return subtema;
    }

    public void setSubtema(Subtema subtema) {
        this.subtema = subtema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Part getFicheiroPdf() {
        return ficheiroPdf;
    }

    public void setFicheiroPdf(Part ficheiroPdf) {
        this.ficheiroPdf = ficheiroPdf;
    }

  


    
  public String registar () throws IOException {
     InputStream inputStream = ficheiroPdf.getInputStream();  
     String fileName=getFilename(ficheiroPdf);
        FileOutputStream outputStream = new FileOutputStream(fileName);  
          
        byte[] buffer = new byte[4096];          
        int bytesRead = 0;  
        while(true) {                          
            bytesRead = inputStream.read(buffer);  
            if(bytesRead > 0) {  
                outputStream.write(buffer, 0, bytesRead);  
            }else {  
                break;  
            }                         
        }  
        outputStream.close();  
        inputStream.close(); 
     //AllHellper.SaveQualquerCoisa(new Investigador(grauacademico, nome, instituicao, datanascimento, utilizador, password, email, telefone, telemovel, null, null, null, null, null, null));
  File f;
 //FileUtils. writeByteArrayToFile(f,buffer);
  
    return "index";
  }   
    private static String getFilename(Part part) {  
        for (String cd : part.getHeader("content-disposition").split(";")) {  
            if (cd.trim().startsWith("filename")) {  
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
            }  
        }  
        return null;  
    }   
}
