package com.example.couponsystem.controller;

import com.example.couponsystem.dao.CouponDAO;
import com.example.couponsystem.dao.ProductDAO;
import com.example.couponsystem.model.Coupon;
import com.example.couponsystem.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductDAO productDAO = new ProductDAO();

    private CouponDAO couponDAO = new CouponDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createProduct(req, resp);
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String coupon = req.getParameter("coupon");

        product.setName(name);
        product.setDescription(description);
        BigDecimal amount = new BigDecimal(price);
        Coupon couponDO = couponDAO.findByCode(coupon);
        product.setPrice(amount.subtract(couponDO.getDiscount()));

        productDAO.save(product);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<h1>Product Added Successfully!</h1>");
        out.println("<a href='/CouponSystem_war_exploded'>Home</a>");
    }
}
