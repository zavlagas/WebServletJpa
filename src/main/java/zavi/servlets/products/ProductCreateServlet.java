/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.servlets.products;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zavi.services.ProductService;

/**
 *
 * @author User
 */
@WebServlet(name = "ProductCreateServlet", urlPatterns = {"/product/create"})
public class ProductCreateServlet extends HttpServlet {
    ProductService service = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productCreateForm.jsp");
        dispatcher.forward(req, resp);

    }
//    
//            <form class="form"action="${pageContext.request.contextPath}/product/create" method="POST">
//                <label for="pdes">Description</label>
//                <input id="pdes" type="text" name="description" /><br>
//                <label for="ppric">Price</label>
//                <input id="ppric" type="number" name="price" /><br>
//                <input class="btn" type="submit" value="Submit" />
//            </form>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pdescr = req.getParameter("description");
        String price = req.getParameter("price");
        service.createProduct(pdescr,price);
        resp.sendRedirect(req.getContextPath()+"/ListProductServlet");
    }

}
