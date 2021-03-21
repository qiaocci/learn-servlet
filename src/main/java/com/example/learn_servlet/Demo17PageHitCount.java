package com.example.learn_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Demo17PageHitCount")
public class Demo17PageHitCount extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int hitCount;

    @Override
    public void init() throws ServletException {
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        hitCount++;
        PrintWriter writer = resp.getWriter();
        writer.println("点击量=" + hitCount);
    }

    @Override
    public void destroy() {

    }
}
