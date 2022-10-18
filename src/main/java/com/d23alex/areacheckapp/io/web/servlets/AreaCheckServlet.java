package com.d23alex.areacheckapp.io.web.servlets;

import com.d23alex.areacheckapp.io.controllers.CheckAreaController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

public class AreaCheckServlet extends HttpServlet {

    private CheckAreaController controller;


    @Override
    public void init() throws ServletException {
        controller = (CheckAreaController) getServletConfig().getServletContext().getAttribute("area-check-controller");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controller.checkArea(request, response);
    }
}
