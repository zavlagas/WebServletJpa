/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.customers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zavi.services.CustomerService;

/**
 *
 * @author User
 */
@WebServlet(name = "CustomerCreateServlet", urlPatterns = {"/customer/create"})
public class CustomerCreateServlet extends HttpServlet {
    
    CustomerService service = new CustomerService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/customerCreateForm.jsp");
        dispatcher.forward(req, resp);
    }

//            <section class="container">
//            <h2>Create Customer</h2>
//            <form class="form" action="${pageContext.request.contextPath}/customer/create" method="POST">
//                <label for="cname">Enter Name</label>
//                <input id="cname" type="text" name="name"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
//            </section>
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        service.createCustomer(name);
        resp.sendRedirect(req.getContextPath() + "/ListCustomerServlet");
    }
    
}
