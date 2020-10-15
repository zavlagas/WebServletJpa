/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.salesman;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zavi.services.SalesmanService;

/**
 *
 * @author User
 */
@WebServlet(name = "SalesmanDeleteFamily", urlPatterns = {"/salesman/deleteFamilyMember"})
public class SalesmanDeleteFamily extends HttpServlet {

    SalesmanService service = new SalesmanService();
//${pageContext.request.contextPath}/salesman/editFamilyMember?mid=${m.fid}&sid=${salesman.scode}"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("mid");
        String salesmanId = req.getParameter("sid");
        service.deleteFamilyMemberBy(memberId);
        resp.sendRedirect(req.getContextPath() + "/salesman/inspectFamily?id=" + salesmanId);
    }

}
