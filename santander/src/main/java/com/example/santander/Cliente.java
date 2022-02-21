package com.example.santander;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet(name="cliente")
public class Cliente extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        String nomeCliente = request.getParameter("nomeCliente");
        PrintWriter out = response.getWriter();
        out.println("<html> <body>");
        out.println("<h1> Cliente " + nomeCliente + " cadastro com sucesso! </h1>");
    }
}
