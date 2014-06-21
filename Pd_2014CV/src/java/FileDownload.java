/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HelpersHibernate.AllHellper;
import HelpersHibernate.GeralHelper;
import HibernatePackage.Artigo;
import HibernatePackage.Grauacademico;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Carlos
 */
@WebServlet(urlPatterns = {"/FileDownload"})
public class FileDownload extends HttpServlet {

 // size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;   
     
    
     
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // get upload id from URL's parameters
        
         
        try {
           
Session session = GeralHelper.GetSession();
        org.hibernate.Transaction tx = null;
        
            tx = session.beginTransaction();

            Artigo at = (Artigo) session.get(Artigo.class, 1);
           
        
            
            if (true) {
                // gets file name and file blob data
                String fileName = result.getString("file_name");
                Blob blob = result.getBlob("file_data");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                 
                System.out.println("fileLength = " + fileLength);
 
                ServletContext context = getServletContext();
 
                // sets MIME type for the file download
                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }              
                 
                // set content properties and header attributes for the response
                response.setContentType(mimeType);
                response.setContentLength(fileLength);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue);
 
                // writes the file to the client
                OutputStream outStream = response.getOutputStream();
                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                inputStream.close();
                outStream.close();             
            } else {
                // no file found
                response.getWriter().print("File not found for the id: ");  
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().print("SQL Error: " + ex.getMessage());
        } 
    }
}
