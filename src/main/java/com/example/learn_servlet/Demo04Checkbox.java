package com.example.learn_servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Demo04Checkbox", value = "/Demo04Checkbox")
public class Demo04Checkbox extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        out.println("菜鸟教程：" + req.getParameter("runoob")); // on
        out.println("Google：" + req.getParameter("google")); // null
        out.println("淘宝教程：" + req.getParameter("taobao")); // on
    }
}
