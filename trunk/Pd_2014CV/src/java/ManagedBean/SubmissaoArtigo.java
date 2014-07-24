/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import HelpersHibernate.AllHellper;
import HibernatePackage.Artigo;
import HibernatePackage.Artigoautores;
import HibernatePackage.Subtema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author Carlos
 */
@Named(value = "artigoRegisto")
@ViewScoped
public class SubmissaoArtigo {

    /**
     * Creates a new instance of ArtigoRegisto
     */
    public SubmissaoArtigo() {
    }
    private Subtema subtema;
    private String titulo;
    private String resumo;
    private Date data;
    private String link;
    private Part ficheiroPdf;
    private int idSubtema;
    private List<Subtema> listSubtema;
    private List<Artigoautores> autores;

    public Subtema getSubtema() {
        if (subtema == null) {
            if (getListSubtema().size() > 0) {
                subtema = listSubtema.get(0);
            }
        }
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

        public int getIdSubtema() {
        return idSubtema;
    }

    public void setIdSubtema(int idSubtema) {
        this.idSubtema = idSubtema;
        for (int i = 0; i < getListSubtema().size(); i++) {
            if (listSubtema.get(i).getId() == idSubtema) {
                subtema = listSubtema.get(i);
            }
        }
    }

    public List<Subtema> getListSubtema() {
        if (listSubtema == null) {
            listSubtema = (List<Subtema>) AllHellper.getListQualquerCoisa(Subtema.class);
        }
        return listSubtema;
    }

    public void setListSubtema(List<Subtema> listSubtema) {
        this.listSubtema = listSubtema;
    }

    public List<Artigoautores> getAutores() {
        if (autores == null) {
            autores = (List<Artigoautores>) AllHellper.getListQualquerCoisa(Artigoautores.class);
        }        
        return autores;
    }

    public void setAutores(List<Artigoautores> autores) {
        this.autores = autores;
    }
    
    public String registar() throws IOException {
        InputStream inputStream = null;
        String caminho;
        try {
            inputStream = ficheiroPdf.getInputStream();
            String fileName = getFilename(ficheiroPdf);
            String[] split = fileName.split("\\.(?=[^\\.]+$)");
            String relativeWebPath = "/upload/PDFs";
            String absoluteDiskPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(relativeWebPath);

            File file = File.createTempFile(split[0], "." + split[1], new File(absoluteDiskPath));
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            caminho = file.getAbsolutePath();
            inputStream.close();
        } catch (Exception e) {
            caminho = "";
        }

        AllHellper.SaveQualquerCoisa(new Artigo(subtema, titulo, resumo, new Date(), link, caminho, null, null, null, null));
        return "/model/artigos/LoginUtilizador.xhtml?faces-redirect=true";
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

    public void validateFile(FacesContext ctx,
            UIComponent comp,
            Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;

        if (file.getSize() > 40000000) {
            msgs.add(new FacesMessage("file too big"));
        }
        if (!"application/pdf".equals(file.getContentType())) {
            msgs.add(new FacesMessage("not a pdf file"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }
    }
}
