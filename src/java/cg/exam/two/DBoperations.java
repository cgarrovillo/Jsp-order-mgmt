/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.exam.two;

import cg.exam.two.domain.Order;
import cg.exam.two.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DBoperations {
    
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        try {
            Connection conn = cp.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products;");
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
                products.add(p);
            }
            
            try {rs.close();} catch (Exception e) {e.printStackTrace();};
            try {st.close();} catch (Exception e) {e.printStackTrace();};
            cp.freeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        try {
            Connection conn = cp.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT o.orderID, o.orderDate, o.fk_productID, o.orderNumberUnitsOrdered, p.productDescription, p.productUnitPrice \n" +
"FROM orders o JOIN products p ON (o.fk_productID = p.productID);");
            while (rs.next()) {
                Order o= new Order(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getFloat(6));
                orders.add(o);
            }
            
            try {rs.close();} catch (Exception e) {e.printStackTrace();};
            try {st.close();} catch (Exception e) {e.printStackTrace();};
            cp.freeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public boolean buy(int id, int amt) {
        String sql = "INSERT INTO orders SET fk_productID=?, orderNumberUnitsOrdered=?";
        ConnectionPool cp = ConnectionPool.getInstance();
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, amt);
           
            int rowsAffected = st.executeUpdate();
            
            try {st.close();} catch (Exception e) {e.printStackTrace();};
            cp.freeConnection(conn);
            
            updateStock(id, amt);
            return (rowsAffected > 0 );
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
    
    private synchronized boolean updateStock(int id, int newStock) {
        String sql = "UPDATE products SET productInStock = productInStock - ? WHERE productID=?";
        ConnectionPool cp = ConnectionPool.getInstance();
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, newStock);
            st.setInt(2, id);
           
            int rowsAffected = st.executeUpdate();
            
            try {st.close();} catch (Exception e) {e.printStackTrace();};
            cp.freeConnection(conn);
            return (rowsAffected > 0 );
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
    
    
}
