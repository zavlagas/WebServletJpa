/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.customers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/ListCustomerServlet"})
public class ListCustomerServlet extends HttpServlet {

    CustomerService service = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Customer> customers = service.findAllCustomers();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/customerList.jsp");
        dispatcher.forward(req, resp);
    }

}
