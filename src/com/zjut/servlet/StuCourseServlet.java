package com.zjut.servlet;

import com.zjut.bean.Student;
import com.zjut.service.StuCourseService;
import com.zjut.service.StuInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StuCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        StuInfoService stuInfoService = new StuInfoService();
        req.setAttribute("student", stuInfoService.queryStuInfo((String) session.getAttribute("ID")));
        Student student = (Student) req.getAttribute("student");
        String ID = student.getID();
        StuCourseService stuCourseService = new StuCourseService();
        req.setAttribute("stuCourseList", stuCourseService.queryStuCourse(ID));
        req.getRequestDispatcher("/WEB-INF/jsp/student/courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
