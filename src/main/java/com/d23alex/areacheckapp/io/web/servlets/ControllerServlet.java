package com.d23alex.areacheckapp.io.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.tree.AbstractLayoutCache;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean areaCheckRequested = req.getParameter("x") != null && req.getParameter("y") != null && req.getParameter("r") != null;
        if (areaCheckRequested)
            getServletContext().getNamedDispatcher("AreaCheckServlet").forward(req, resp);
        else
            getServletContext().getNamedDispatcher("MainPageServlet").forward(req, resp);
    }
}
