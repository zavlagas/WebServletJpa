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
@WebServlet(name = "SalesmanDeleteServlet", urlPatterns = {"/salesman/deleteSalesman"})
public class SalesmanDeleteServlet extends HttpServlet {

    SalesmanService service = new SalesmanService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        service.deleteSalesmanBy(id);
        resp.sendRedirect(req.getContextPath() + "/ListSalesmanServlet");
    }
    
}
