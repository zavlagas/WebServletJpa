/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.customers;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CustomerDeleteServlet", urlPatterns = {"/customer/deleteCustomer"})
public class CustomerDeleteServlet extends HttpServlet {
    
    CustomerService service = new CustomerService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        service.deleteCustomerBy(id);
        response.sendRedirect(request.getContextPath() + "/ListCustomerServlet");
        
    }
    
}
