package com.qtech.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCodeServlet extends HttpServlet {

	private static Random r = new Random();
    private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int NUMBER_OF_CHS = 4;
    private static final int IMG_WIDTH = 65;
    private static final int IMG_HEIGHT = 25;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);    
            Graphics g = image.getGraphics();
            Color c = new Color(200, 200, 255);                                                                                 
            g.setColor(c);
            g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);                                        
            
            StringBuffer sb = new StringBuffer();
            int index;                                                                     
            for (int i = 0; i < NUMBER_OF_CHS; i++) {
                index = r.nextInt(chs.length);                                              
                g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));       
                g.drawString(chs[index] + "", 15 * i + 3, 18);                              
                sb.append(chs[index]);                                                      
            }
            System.out.println(sb);
            request.getSession().setAttribute("piccode", sb.toString());                   
            ImageIO.write(image, "jpg", response.getOutputStream());                        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
