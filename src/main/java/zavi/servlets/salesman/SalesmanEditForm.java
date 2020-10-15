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
@WebServlet(name = "SalesmanEditForm", urlPatterns = {"/salesman/editSalesman"})
public class SalesmanEditForm extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Salesman salesman = service.findSalesmanBy(id);
        request.setAttribute("salesman", salesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/salesmanEditForm.jsp");
        dispatcher.forward(request, response);
    }

//     <form class="form" action="${pageContext.request.contextPath}/salesman/editSalesman" method="POST" >
//                <label for="slid">Id</label>
//                <input id="slid" type="number" value="${salesman.scode}" name="id" readonly />
//                <label for="slname">Enter Name</label>
//                <input id="slname" type="text" value="${salesman.sname}" name="name"/>
//                <label for="slCity">Enter City</label>
//                <input id="slCity" type="text" value="${salesman.scity}" name="city"/>
//                <label for="slcomm">Enter Commision</label>
//                <input id="slcomm" type="number" value="${salesman.scomm}" name="comm"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String comm = request.getParameter("comm");
        service.updateSalesman(id,name,city,comm);
        response.sendRedirect(request.getContextPath() + "/ListSalesmanServlet");

    }

}
