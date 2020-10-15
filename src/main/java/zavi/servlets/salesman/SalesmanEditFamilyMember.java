/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.salesman;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zavi.entities.Family;
import zavi.services.SalesmanService;

/**
 *
 * @author User
 */
@WebServlet(name = "SalesmanEditFamilyMember", urlPatterns = {"/salesman/editFamilyMember"})
public class SalesmanEditFamilyMember extends HttpServlet {

    SalesmanService service = new SalesmanService();
//${pageContext.request.contextPath}/salesman/editFamilyMember?mid=${m.fid}&sid=${salesman.scode}"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberId = req.getParameter("mid");
        String salesmanId = req.getParameter("sid");
        Family member = service.getFamilyMemberBy(memberId);
        req.setAttribute("salesmanId", salesmanId);
        req.setAttribute("member", member);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/editSalesmanFamilyForm.jsp");
        dispatcher.forward(req, resp);
    }

//                <input type="hidden" name="id" value="${salesmanId}"/>
//                <label for="fname">Name</label>
//                <input id="fname" type="text" name="name" value="${member.fname}"/>
//                <label for="relation">Relationship</label>
//                <input id="relation" type="text" name="relation" value="${member.frelationship}"/>
//                <label for="dob">Date Of Birth</label>
//                <input id="dob" type="date" name="dob" value="${member.dob}"/>
//                <input class="btn" type="submit" value="Submit"/>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String salesmanId = req.getParameter("sid");
        String memberId = req.getParameter("mid");
        String name = req.getParameter("name");
        String relation = req.getParameter("relation");
        String dob = req.getParameter("dob");
        service.updateSalesmanFamilyMember(memberId, name, relation, dob);
        resp.sendRedirect(req.getContextPath() + "/salesman/inspectFamily?id=" + salesmanId);
    }

}
