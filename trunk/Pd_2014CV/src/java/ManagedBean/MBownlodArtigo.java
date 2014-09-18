/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
@Named(value = "mBownlodArtigo")
@ViewScoped
public class MBownlodArtigo {

    /**
     * Creates a new instance of MBownlodArtigo
     */
    public MBownlodArtigo() {
    }
    
    public void downloadFile() {

    File file = new File("/home/marco/file.txt");
    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  

    response.setHeader("Content-Disposition", "attachment;filename=file.txt");  
    response.setContentLength((int) file.length());  
    ServletOutputStream out = null;  
    try {  
        FileInputStream input = new FileInputStream(file);  
        byte[] buffer = new byte[20000];  
        out = response.getOutputStream();  
        int i = 0;  
        while ((i = input.read(buffer)) != -1) {  
            out.write(buffer);  
            out.flush();  
        }  
        FacesContext.getCurrentInstance().getResponseComplete();  
    } catch (IOException err) {  
        err.printStackTrace();  
    } finally {  
        try {  
            if (out != null) {  
                out.close();  
            }  
        } catch (IOException err) {  
            err.printStackTrace();  
        }  
    }  

}
    
}
