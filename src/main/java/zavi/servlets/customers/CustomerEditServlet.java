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
import zavi.entities.Customer;
import zavi.services.CustomerService;

/**
 *
 * @author User
 */
@WebServlet(name = "CustomerEditServlet", urlPatterns = {"/customer/editCustomer"})
public class CustomerEditServlet extends HttpServlet {
    
    CustomerService service = new CustomerService();
//    <a class="btn" href="customer/editCustomer?id=${cu.ccode}">Edit</a></td>
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = service.findCustomerBy(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/customerEditForm.jsp");
        dispatcher.forward(request, response);
    }
//
//            <form class="form" action="${pageContext.request.contextPath}/customer/editCustomer" method="POST">
//                <label for="customerid">Id</label>
//                <input id="customerid" type="number" value="${customer.ccode}" readonly name="id"/>
//                <label for="cname">Name</label>
//                <input id="cname" type="text" value="${customer.cname}"name="name"/>
//                <input class="btn" type="submit" value="Submit"/>
//            </form>
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        
        service.updateCustomer(id, name);
        
        response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
    }
    
}
