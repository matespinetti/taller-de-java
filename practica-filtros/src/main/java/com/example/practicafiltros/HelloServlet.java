package com.example.practicafiltros;

import java.io.*;
import java.util.ResourceBundle;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class    HelloServlet extends HttpServlet {




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ResourceBundle texts = (ResourceBundle) request.getAttribute("textos");
        System.out.println("Textos: " + texts);
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + texts.getString("text") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}