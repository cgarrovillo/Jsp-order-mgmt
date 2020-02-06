<%-- 
    Document   : index
    Created on : Nov 13, 2019, 1:15:39 PM
    Author     : Administrator
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    <body>
        <h1>Orders - Exam 2 Fall 2019</h1>
        <h2>Products</h2>
        <table>
            <tr>
                <th>Product</th>
                <th>Num In Stock</th>
                <th>Unit Price</th>
                
            </tr>
            <c:forEach var="product" items="${requestScope.products}">
                <tr>
                    <td>${product.desc}</td>
                    <td>${product.stock}</td>
                    <td>
                        <fmt:formatNumber type="currency" value="${product.price}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <h2>Order Product</h2>
        <div>
            <form action="OrderController" method="GET">
                <label for="select">Product: </label>
                <select name="selections">
                    <c:forEach var="product" items="${requestScope.products}">
                        <option value="${product.id}">${product.desc}</option>
                    </c:forEach>
                </select> <br/>
                <label for="amt">Number: </label> 
                <input name="amt" type="number" min="0" step="1"> <br/>
                <input name="buy" type="submit" value="Buy">
            </form>
            <p>${requestScope.message}</p>
        </div>
        
        
        <h2>Orders</h2>
        <table>
            <tr>
                <th>Date</th>
                <th>Product</th>
                <th>Unit Price</th>
                <th>Number Ordered</th>
                <th>TOTAL</th>
            </tr>
            <c:forEach var="order" items="${requestScope.orders}">
                <tr>
                    <td>${order.date}</td>
                    <td>${order.productDesc}</td>
                    <td>
                        <fmt:formatNumber type="currency" value="${order.productPrice}"/>
                    </td>
                    <td>${order.unitsOrdered}</td>
                    <td>
                        <fmt:formatNumber type="currency" value="${order.productPrice * order.unitsOrdered}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
