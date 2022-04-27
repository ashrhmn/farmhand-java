/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author ash
 */
public class Order {

    private User user;
    private String date;
    private Integer id;
    private ArrayList<OrderItems> items;
    private Double paidAmount;
    private String orderStatus;
    private String paymentStatus;
    private String deliveryStatus;
    private Double totalBillPrice;
    private User agent;
    private User deliveredBy;

    public Order() {
        user = new User();
        items = new ArrayList<>();
    }


    public Order(User user, String date, Integer id, ArrayList<OrderItems> items, Double paidAmount, String orderStatus, String paymentStatus, String deliveryStatus, Double totalBillPrice, User agent, User deliveredBy) {
        this.user = user;
        this.date = date;
        this.id = id;
        this.items = items;
        this.paidAmount = paidAmount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.deliveryStatus = deliveryStatus;
        this.totalBillPrice = totalBillPrice;
        this.agent = agent;
        this.deliveredBy = deliveredBy;
        
        this.totalBillPrice = 0.0;
        for(int i=0;i<this.items.size();++i){
            this.totalBillPrice += (this.items.get(i).getAmount()*this.items.get(i).getProduct().getPrice());
        }
    }
    
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<OrderItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItems> items) {
        this.items = items;
        this.totalBillPrice = 0.0;
        for(int i=0;i<this.items.size();++i){
            this.totalBillPrice += (this.items.get(i).getAmount()*this.items.get(i).getProduct().getPrice());
        }
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getTotalBillPrice() {
        return totalBillPrice;
    }

    public void setTotalBillPrice() {
        this.totalBillPrice = 0.0;
        for(int i=0;i<this.items.size();++i){
            this.totalBillPrice += (this.items.get(i).getAmount()*this.items.get(i).getProduct().getPrice());
        }
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public User getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredVy(User deliveredBy) {
        this.deliveredBy = deliveredBy;
    }
}
