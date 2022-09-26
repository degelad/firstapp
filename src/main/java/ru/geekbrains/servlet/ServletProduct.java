/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ru.geekbrains.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.content.Product;

/**
 *
 * @author degelad
 */
public class ServletProduct extends HttpServlet {

    StringBuffer sb;
    Product product;

    private static Logger logger = LoggerFactory.getLogger(ServletProduct.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletProduct at " + request.getContextPath() + "</h1>");
            out.println("<a href=\"/firstapp-snapshot-1\">на главную</a>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sb = new StringBuffer();
        for (int i = 1; i < 11; i++) {
            product = new Product(i, "product-" + i, 1.0 * i);
            sb.append("id " + product.getId()).append(" ").append("name " + product.getTitle()).append(" ").append("cost " + product.getCost()).append("</br> ");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head> <title> Product list</title> </head>");
        out.println("<body>");
        out.println(sb);
        out.println("</br><a href=\"/firstapp-snapshot-1\">на главную</a>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("New POST request");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
