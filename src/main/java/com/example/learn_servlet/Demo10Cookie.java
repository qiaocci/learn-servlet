package com.example.learn_servlet;

import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/Demo10Cookie")
public class Demo10Cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"), "utf8"));
        Cookie url = new Cookie("url", req.getParameter("url"));

        name.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);

        name.setPath("/");
        url.setPath("/");

        resp.addCookie(name);
        resp.addCookie(url);

        PrintWriter out = resp.getWriter();
        out.println("done");
    }
}
