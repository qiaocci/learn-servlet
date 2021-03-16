package com.example.learn_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Demo01GetMethod", value = "/Demo01GetMethod")
public class Demo01GetMethod extends HttpServlet {
    private String message;

    // 初始化后
    public void init() {
        message = "hello qiaocc";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String name = new String(request.getParameter("name").getBytes(StandardCharsets.UTF_8), "utf8");
        out.println("name=" + name + " age=" + request.getParameter("age"));
    }

    //    销毁前
    public void destroy() {
    }
}