package com.ylsislove.servlet.research.project;

import com.ylsislove.service.research.ResearchProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除项目条目
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/7 16:44
 */
@WebServlet(value = "/researchProjectDeleteAll.action")
public class ResearchProjectDeleteAllServlet extends HttpServlet {

    private ResearchProjectService rService = new ResearchProjectService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] ids = request.getParameterValues("data");
        for (String id : ids) {
            boolean isSuccess = rService.delete(Integer.parseInt(id));
            if (!isSuccess) {
                System.out.println(id+"项目条目删除失败");
                response.getWriter().print(id+"删除失败");
                return;
            }
        }
        System.out.println("项目条目批量删除成功");
    }
}
