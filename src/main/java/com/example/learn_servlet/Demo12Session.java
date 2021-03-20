package com.example.learn_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Demo12Session")
public class Demo12Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String title = "Servlet Session教程";
        Integer visitCount = 0;
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("qiaocc");

        if (session.getAttribute(visitCountKey) == null) {
            session.setAttribute(visitCountKey, 0);
        }

        if (session.isNew()) {
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount += 1;
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session 信息</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session 信息</th><th>值</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>创建时间</td>\n" +
                "  <td>" + df.format(createTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>最后访问时间</td>\n" +
                "  <td>" + df.format(lastAccessTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>用户 ID</td>\n" +
                "  <td>" + userID +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>访问统计：</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");

    }
}
