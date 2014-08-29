/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Valter
 */
@Named(value = "MBPrincipalSlideShow")
@SessionScoped
public class MBPrincipalSlideShow implements Serializable {
    private String selectedImage;
    
    /**
     * Creates a new instance of MBPrincipalSlideShow
     */
    public MBPrincipalSlideShow() {
    }
    
}
