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


@WebServlet("/Demo14Upload")
public class Demo14Upload extends HttpServlet {
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3M
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40M
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50M

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(req)) {
            PrintWriter out = resp.getWriter();
            out.println("Error: 表单必须包含enctype=multipart/form-date");
            out.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值,超过后将产品临时文件并存储到临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置文件最大值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置请求最大值(包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("utf8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对于当前应用的目录
        String uploadPath = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不是表单的字段,也就是上传文件的字段啦
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("输出文件上传路径: " + filePath);

                        item.write(storeFile);
                        req.setAttribute("message", "文件保存成功");
                    } else {
                        String name = item.getFieldName();
                        String value = item.getString();
                        System.out.println("普通表单字段:" + name + ": " + value);
                    }
                }
            }

        } catch (Exception e) {
            req.setAttribute("message", "错误信息" + e.getMessage());
        }

        req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);


    }
}
