package com.example.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "menuServlet", value = "/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String perfil = (String) req.getAttribute("perfil");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("<title>Bienvenido</title>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/encabezado");
        if (dispatcher != null) {
            dispatcher.include(req, resp);
        }
        resp.getWriter().write("<h3>Bienvenido: " + perfil + "</h1>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
