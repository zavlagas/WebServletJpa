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
import zavi.services.SalesmanService;

/**
 *
 * @author User
 */
@WebServlet(name = "SalesmanCreateForm", urlPatterns = {"/salesman/createSalesman"})
public class SalesmanCreateForm extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/salesmanCreateForm.jsp");
        dispatcher.forward(request, response);
    }

//                <form class="form" action="${pageContext.request.contextPath}/salesman/createSalesman" method="POST" >
//                <label for="slname">Enter Name</label>
//                <input id="slname" type="text" name="name"/>
//                <label for="slCity">Enter City</label>
//                <input id="slCity" type="text" name="city"/>
//                <label for="slcomm">Enter Commision</label>
//                <input id="slcomm" type="number" name="comm"/>
//                <input class="btn" type="submit" value="Submit"/>
//                </form>
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String comm = request.getParameter("comm");
        
        service.createSalesman(name,city,comm);
        response.sendRedirect(request.getContextPath() + "/ListSalesmanServlet");
    }
    
}
