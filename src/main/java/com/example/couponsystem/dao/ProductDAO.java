package com.example.couponsystem.dao;

import com.example.couponsystem.model.Coupon;
import com.example.couponsystem.model.Product;
import com.example.couponsystem.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public void save(Product product) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into product (name,description,price) values(?,?,?)");
            stmt.setString(1,product.getName());
            stmt.setString(2,product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
