package com.example.clasificados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public void init() {
        usuarios.add(new Usuario("administrador", "administrador", "administrador"));
        usuarios.add(new Usuario("publicador", "publicador", "publicador"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String user = req.getParameter("username");
        String password = req.getParameter("password");
        Usuario usuario = this.usuarios.stream().filter(u -> u.getNombre().equals(user) && u.getClave().equals(password)).findFirst().orElse(null);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/menu");
        if (dispatcher != null) {
            if (usuario == null){
                req.setAttribute("perfil", "error");
            } else {
                req.setAttribute("perfil", usuario.getPerfil());

            }

            dispatcher.forward(req, resp);


        }


    }

    public void destroy() {
    }
}