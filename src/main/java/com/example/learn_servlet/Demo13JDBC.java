package com.example.learn_servlet;

import com.example.learn_servlet.utils.JDBCUtils_DBCP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Demo13JDBC")
public class Demo13JDBC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PrintWriter out = resp.getWriter();

        try {
            connection = JDBCUtils_DBCP.getConnection();
            String sql = "select * from websites";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                out.println("id=" + resultSet.getObject("id"));
                out.println("name=" + resultSet.getObject("name"));
                out.println("url=" + resultSet.getObject("url"));
                out.println("alexa排名=" + resultSet.getObject("alexa"));
                out.println("国家=" + resultSet.getObject("country"));
                out.println("<br />");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
