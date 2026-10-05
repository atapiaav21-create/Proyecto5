package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.Wallet;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Wallet wallet = (Wallet) session.getAttribute("wallet");

        if (wallet == null) {
            wallet = new Wallet();
            session.setAttribute("wallet", wallet);
        }

        request.setAttribute("saldo", wallet.getSaldo());

        request.getRequestDispatcher("/wallet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Wallet wallet = (Wallet) session.getAttribute("wallet");

        if (wallet == null) {
            wallet = new Wallet();
            session.setAttribute("wallet", wallet);
        }

        String accion = request.getParameter("accion");
        String montoTexto = request.getParameter("monto");

        try {
            double monto = Double.parseDouble(montoTexto);

            if ("depositar".equals(accion)) {
                wallet.depositar(monto);
            } else if ("retirar".equals(accion)) {
                wallet.retirar(monto);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Ingresa un monto válido.");
        }

        response.sendRedirect(request.getContextPath() + "/wallet");
    }
}