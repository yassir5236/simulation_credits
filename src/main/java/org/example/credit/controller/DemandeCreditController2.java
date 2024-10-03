package org.example.credit.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DemandeCreditController2 extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int age = Integer.parseInt(req.getParameter("age"));
        double cout = Double.parseDouble(req.getParameter("cout"));
        date duree = ;
        String email = req.getParameter("email");
        String etat = req.getParameter("etat");
        etat

    }


}