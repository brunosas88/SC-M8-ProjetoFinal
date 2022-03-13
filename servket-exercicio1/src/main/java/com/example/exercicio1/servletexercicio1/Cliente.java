package com.example.exercicio1.servletexercicio1;

import com.example.exercicio1.servletexercicio1.model.ClienteModel;
import com.example.exercicio1.servletexercicio1.model.ListaClientes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="Cliente", value="/cliente")
public class Cliente extends HttpServlet {

    ListaClientes listaClientes = new ListaClientes();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nomeCliente = request.getParameter("nomeCliente");
        String emailCliente = request.getParameter("emailCliente");
        String contaCliente = request.getParameter("contaCliente");
        String agenciaCliente = request.getParameter("agenciaCliente");
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(nomeCliente);
        cliente.setEmail(emailCliente);
        cliente.setConta(contaCliente);
        cliente.setAgencia(agenciaCliente);

        listaClientes.adicionar(cliente);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("clienteCadastrado.jsp");
        request.setAttribute("cliente", cliente.getNome());
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ClienteModel> clientes = listaClientes.buscarClientes();

        request.setAttribute("clientes", clientes);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaClientes.jsp");
        requestDispatcher.forward(request, response);

    }

}
