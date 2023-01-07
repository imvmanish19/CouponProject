package com.example.couponsystem.controller;


import com.example.couponsystem.dao.CouponDAO;
import com.example.couponsystem.model.Coupon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/coupons")
public class CouponController extends HttpServlet {

    private CouponDAO couponDAO = new CouponDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("create")) {
            createCoupon(req,resp);
        } else if(action.equals("find")) {
            findCoupon(req,resp);
        }
    }

    public void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Coupon coupon = new Coupon();
        String code = request.getParameter("code");
        String discount = request.getParameter("discount");
        String expDate = request.getParameter("expDate");

        coupon.setCode(code);
        coupon.setDiscount(new BigDecimal(discount));
        coupon.setExpDate(expDate);

        couponDAO.save(coupon);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Coupon Created By Admin</h1>");
        out.println("<a href='/CouponSystem_war_exploded'>Home</a>");
    }

    public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        Coupon coupon = couponDAO.findByCode(code);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h1>Find Coupon Successful!</h1>");
        out.println(coupon);
        out.println("<h1>Use it for whooping discounts!</h1>");
        out.println("<a href='/CouponSystem_war_exploded'>Home</a>");
    }
}
