/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ash
 */
public class OrderItems {
    private Product product;
    private Double amount;

    
    public OrderItems(Product product, Double amount) {
        this.product = product;
        this.amount = amount;
    }

    public OrderItems() {
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
