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
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/Demo11ReadCookie")
public class Demo11ReadCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = req.getCookies();

        if (cookies != null) {
            out.println("<h2>Cookie 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("name") == 0) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    out.print("已删除的 cookie：" +
                            cookie.getName() + "<br/>");
                }
                out.print("名称：" + cookie.getName() + "，");
                out.print("值：" + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br/>");
            }
        } else {
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
