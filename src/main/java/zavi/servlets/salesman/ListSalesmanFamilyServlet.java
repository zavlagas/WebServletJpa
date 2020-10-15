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
@WebServlet(name = "ListSalesmanFamilyServlet", urlPatterns = {"/salesman/inspectFamily"})
public class ListSalesmanFamilyServlet extends HttpServlet {

    SalesmanService service = new SalesmanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Salesman salesman = service.findSalesmanWithFamilyBy(id);
        req.setAttribute("salesman", salesman);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/salesman/salesmanFamilyList.jsp");
        dispatcher.forward(req, resp);
    }

}
