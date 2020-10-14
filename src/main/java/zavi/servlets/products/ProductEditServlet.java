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
import zavi.entities.Product;
import zavi.services.ProductService;

/**
 *
 * @author User
 */
@WebServlet(name = "ProductEditServlet", urlPatterns = {"/product/editProduct"})
public class ProductEditServlet extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product p = service.findProductBy(id);
        req.setAttribute("product", p);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productEditForm.jsp");
        dispatcher.forward(req, resp);
    }

//                <form class="form" action="${pageContext.request.contextPath}/product/editProduct" method="POST">
//                    <label for="pcode">Code</label>
//                    <input id="pcode" type="text" name="pcode" value="${product.pcode}" readonly/><br>
//                    <label for="pdescr">Description</label>
//                    <input id="pdescr" type="text" name="description" value="${product.pdescr}" /><br>
//                    <label for="pprice">Price</label>
//                    <input id="pprice" type="number" step="0.01" min="0" name="price" value="${product.pprice}" /><br>
//                <input class="btn" type="submit" value="Submit" />
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pcode = req.getParameter("pcode");
        String pdescr = req.getParameter("description");
        String pprice = req.getParameter("price");

        service.updateProduct(pcode, pdescr, pprice);
        resp.sendRedirect(req.getContextPath()+"/ListProductServlet");

    }

}
