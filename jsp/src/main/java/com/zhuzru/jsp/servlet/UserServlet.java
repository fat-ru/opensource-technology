package com.zhuzru.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述：用户Servlet类
 *
 * @Date 2025/11/29 21:57
 * @Created by zhuzru
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "张三");
        req.setAttribute("age", 25);

        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
