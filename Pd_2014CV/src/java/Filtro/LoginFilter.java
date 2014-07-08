/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Filtro;

import ManagedBean.LoginUtilizador;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */

public class LoginFilter implements Filter{
@Inject
private LoginUtilizador loginUtilizador;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
   HttpServletRequest req = (HttpServletRequest) request;
        LoginUtilizador  auth = (LoginUtilizador ) req.getSession().getAttribute("auth");
        loginUtilizador.isLoggedIn();
        String n=loginUtilizador.getUsername();
            if (auth == null || !auth .isLoggedIn()) {
                String contextPath = ((HttpServletRequest) request).getContextPath();
                ((HttpServletResponse) response).sendRedirect(contextPath + "/faces/model/investigador/LoginUtilizador.xhtml");
            }

            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
}
