/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zavi.services;

import java.util.List;
import zavi.dao.ProductDao;
import zavi.entities.Product;

/**
 *
 * @author User
 */
public class ProductService {

    ProductDao pdao = new ProductDao();

    public List<Product> getAllProducts() {
        List<Product> products = pdao.getAllProducts();
        return (products);
    }

    public void createProduct(String pdescr, String price) {
        double pprice = Double.parseDouble(price);
        Product p = new Product(pdescr, pprice);
        pdao.createProduct(p);
    }

    public Product findProductBy(String id) {
        int pcode = Integer.parseInt(id);
        Product p = pdao.findProductBy(pcode);
        return (p);
    }

    public void updateProduct(String pcode, String pdescr, String price) {
        Product p = findProductBy(pcode);
        double pprice = Double.parseDouble(price);
        p.setPdescr(pdescr);
        p.setPprice(pprice);
        pdao.updateProduct(p);
    }

    public void deleteProduct(String id) {
        Product p = findProductBy(id);
        pdao.deleteProduct(p);
    }

}
