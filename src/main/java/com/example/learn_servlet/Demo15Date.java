package com.example.learn_servlet;

import com.example.learn_servlet.utils.JDBCUtils_DBCP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.security.PrivateKey;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/Demo15Date")
public class Demo15Date extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Date date = new Date();
        out.println(date.toString());

        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd  hh:mm:ss E a ");
        out.println(ft.format(date));
    }
}
