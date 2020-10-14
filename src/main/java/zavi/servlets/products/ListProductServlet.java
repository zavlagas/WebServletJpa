/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.products;

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
import zavi.entities.Product;
import zavi.services.ProductService;

/**
 *
 * @author User
 */
@WebServlet(name = "ListProductServlet", urlPatterns = {"/ListProductServlet"})
public class ListProductServlet extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = service.getAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
        dispatcher.forward(req, resp);

    }

}
