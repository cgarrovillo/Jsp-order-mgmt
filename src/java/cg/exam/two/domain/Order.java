/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.exam.two.domain;

/**
 *
 * @author Administrator
 */
public class Order {
    
    private int orderID;
    private String date;
    private int productID;
    private int unitsOrdered;
    
    private String productDesc;
    private float productPrice;

    public Order(int orderID, String date, int productID, int unitsOrdered, String productDesc, float productPrice) {
        this.orderID = orderID;
        this.date = date;
        this.productID = productID;
        this.unitsOrdered = unitsOrdered;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    
    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUnitsOrdered() {
        return unitsOrdered;
    }

    public void setUnitsOrdered(int unitsOrdered) {
        this.unitsOrdered = unitsOrdered;
    }
    
    
    
}
