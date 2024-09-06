package com.example.festival;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ImprimeCuponServlet", value = "/imprime")
public class ImprimeCuponServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream outputStream = resp.getOutputStream();
        String texto = req.getParameter("texto");

        // Create an image
        BufferedImage image = new BufferedImage(2044, 1173, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // Draw the background image
        BufferedImage img = ImageIO.read(this.getServletContext().getResourceAsStream("/WEB-INF/img/cupon.jpg"));
        graphics.drawImage(img, 0, 0, null);

        // Set the font and color
        graphics.setFont(new Font("Arial", Font.BOLD, 50));
        graphics.setColor(Color.WHITE);

        // Calculate position for the text
        int x = 573;
        int y = 1000;

        // Draw the text on top of the image
        graphics.drawString(texto, x, y);

        // Write the image to the output stream
        javax.imageio.ImageIO.write(image, "jpeg", outputStream);
        outputStream.close();


    }


}