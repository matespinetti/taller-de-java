package com.example.clasificados;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InicializaSitioListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String nombre = sce.getServletContext().getInitParameter("nombre_sitio");
        String email = sce.getServletContext().getInitParameter("email");
        String telefono = sce.getServletContext().getInitParameter("telefono");

        SitioClasificado sitio = new SitioClasificado(nombre, email, telefono);

        ServletContext contexto = sce.getServletContext();
        contexto.setAttribute("sitio", sitio);

    }
}
