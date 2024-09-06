package com.example.clasificados;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "encabezadoServlet", value = "/encabezado")
public class Encabezado extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        SitioClasificado sitio = (SitioClasificado) req.getServletContext().getAttribute("sitio");
        resp.getWriter().write("<h1>" + sitio.getNombre() + "</h1>");
        resp.getWriter().write("<p>Email: " + sitio.getEmail() + "</p>");
        resp.getWriter().write("<p>Telefono: " + sitio.getTelefono() + "</p>");

    }
}
