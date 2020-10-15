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
import zavi.entities.Salesman;
import zavi.services.SalesmanService;

/**
 *
 * @author User
 */
@WebServlet(name = "SalesmanCreateFamilyMember", urlPatterns = {"/salesman/createSalesmanFamily"})
public class SalesmanCreateFamilyMember extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Salesman salesman = service.findSalesmanBy(id);
        req.setAttribute("salesman", salesman);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/createFamilyMember.jsp");
        dispatcher.forward(req, resp);
    }

//              <form class="form" action="${pageContext.request.contextPath}/salesman/createSalesmanFamily" method="POST" >
//                <input type="hidden" name="id" value="${salesman.scode}"/>
//                <label for="fname">Enter Name</label>
//                <input id="fname" type="text" name="name"/>
//                <label for="relation">Enter Relationship</label>
//                <input id="relation" type="text" name="relation"/>
//                <label for="dob">Enter Date Of Birth</label>
//                <input id="dob" type="date" name="dob"/>
//                <input class="btn" type="submit" value="Submit"/>
//              </form>
//    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        String name = req.getParameter("name");
        String relation = req.getParameter("relation");
        String dob = req.getParameter("dob");
        service.createSalesmanFamilyMember(sid, name, relation, dob);
        resp.sendRedirect(req.getContextPath() + "/salesman/inspectFamily?id=" + sid);
    }

}
