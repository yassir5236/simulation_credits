package org.example.credit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/storeForm2")
public class Form2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String telephone = request.getParameter("tel");

        StringBuilder errorMessage = new StringBuilder();

        if (email == null || email.trim().isEmpty()) {
            errorMessage.append("L'email est obligatoire. ");
        }

        if (telephone == null || telephone.trim().isEmpty()) {
            errorMessage.append("Le numéro de téléphone est obligatoire. ");
        }

//            if (errorMessage.length() > 0) {
//                request.setAttribute("errorMessage", errorMessage.toString());
//                request.getRequestDispatcher("storeForm2.jsp").forward(request, response);
//                return;
//            }

            session.setAttribute("email", email);
            session.setAttribute("telephone", telephone);

            System.out.println(email);
            System.out.println(telephone);
            System.out.println("donne2");

            response.sendRedirect("storeForm3.jsp");
        }

//    private boolean isValidEmail(String email) {
//        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$";
//        return Pattern.matches(emailRegex, email);
//    }
//
//    private boolean isValidTelephone(String telephone) {
//        String phoneRegex = "^[0-9]{10}$";
//        return Pattern.matches(phoneRegex, telephone);
//    }
    }

