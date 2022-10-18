package com.d23alex.areacheckapp.io.web.servlets;

import com.d23alex.areacheckapp.io.controllers.MainFormAndHistoryController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MainFormAndHistory", value = "/main")
public class MainPageServlet extends HttpServlet {
    private MainFormAndHistoryController controller;


    @Override
    public void init() throws ServletException {
        controller = (MainFormAndHistoryController) getServletConfig().getServletContext().getAttribute("area-check-controller");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        controller.getMainFormAndHistory(req, res);
    }
}
