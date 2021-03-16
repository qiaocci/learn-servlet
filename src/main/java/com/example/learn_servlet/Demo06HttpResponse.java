package com.example.learn_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/Demo06HttpResponse")
public class Demo06HttpResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setIntHeader("Refresh", 1);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        Calendar calendar = Calendar.getInstance();
        Date taskTime = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(taskTime);
        String title = "自动刷新 Header 设置 - 菜鸟教程实例";


        out.println("title=" + title);
        out.println(nowTime);

    }
}
