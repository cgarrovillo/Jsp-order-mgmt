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
public class Product {
    
    private int id;
    private String desc;
    private int stock;
    private float price;

    public Product(int id, String desc, int stock, float price) {
        this.id = id;
        this.desc = desc;
        this.stock = stock;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", desc=" + desc + ", stock=" + stock + ", price=" + price + '}';
    }
    
    
}
