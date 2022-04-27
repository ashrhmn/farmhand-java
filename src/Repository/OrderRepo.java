/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entity.Order;
import Entity.OrderItems;
import Entity.Product;
import Entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ash
 */
public class OrderRepo {
    DBconnection dbc;
    UserRepo ur;
    ArrayList<OrderItems> items;

    public OrderRepo() {
        dbc = new DBconnection();
        ur = new UserRepo();
        items = new ArrayList<>();
    }
    
    public ArrayList<OrderItems> getOrderItems(Integer orderId){
        items.clear();
        dbc.openConnection();
        try {
           dbc.result = dbc.st.executeQuery("SELECT orderedItems.itemName,itemsPrice.category,orderedItems.orderId,orderedItems.amount,orderedItems.unitPrice from orderedItems INNER JOIN itemsPrice on orderedItems.itemName=itemsPrice.item where orderedItems.orderId="+orderId+"");
           while(dbc.result.next()){
               OrderItems item;
               Product product = new Product();
               product.setName(dbc.result.getString("itemName"));
               product.setCategory(dbc.result.getString("category"));
               product.setPrice(dbc.result.getDouble("unitPrice"));
               items.add(new OrderItems(product, dbc.result.getDouble("amount")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
        dbc.closeConnection();
        return items;
    }
    
    public Order getOrder(Integer orderId){
        Order order = new Order();
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from orders where orderId="+orderId+"");
            if(dbc.result.next()){
                order.setUser(ur.getUser(dbc.result.getString("username")));
                order.setDate(dbc.result.getString("date"));
                order.setDeliveryStatus(dbc.result.getString("delivery"));
                order.setPaidAmount(dbc.result.getDouble("paidAmount"));
                order.setId(orderId);
                order.setOrderStatus(dbc.result.getString("status"));
                order.setPaymentStatus(dbc.result.getString("payment"));
                order.setAgent(ur.getUser(dbc.result.getString("agent")));
                order.setDeliveredVy(ur.getUser(dbc.result.getString("deliveredBy")));
                order.setItems(getOrderItems(orderId));
            }
            else{
                
            }

             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dbc.closeConnection();
        

        return order;
    }
    
    
    public ArrayList<Integer> getOrders(){
        ArrayList<Integer> ids = new ArrayList<>();
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from orders");
            while(dbc.result.next()){
                ids.add(dbc.result.getInt("orderId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return ids;
    }
    public void saveNewOrder(Order newOrder){
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into orders values('"+newOrder.getUser().getUserId()+"','"+newOrder.getId()+"','"+newOrder.getDate()+"','"+newOrder.getPaidAmount()+"','"+newOrder.getOrderStatus()+"','"+newOrder.getPaymentStatus()+"','"+newOrder.getDeliveryStatus()+"','"+newOrder.getAgent().getUserId()+"','"+newOrder.getDeliveredBy().getUserId()+"')");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dbc.closeConnection();
        for(int i=0;i<newOrder.getItems().size();++i){
            saveOrderedItem(newOrder.getId(), newOrder.getItems().get(i));
        }
    }
    
    public void saveOrderedItem(Integer orderId,OrderItems item){
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into orderedItems values("+orderId+",'"+item.getProduct().getName()+"',"+item.getAmount()+","+item.getProduct().getPrice()+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbc.closeConnection();
    }
    
    public Integer generateNewOrderId(){
        int id = 1;
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("SELECT * FROM `orders` ORDER BY `orders`.`orderId` ASC");
            boolean unique = false;
            while(!unique){
                unique = true;
                while(dbc.result.next()){
                    if(id == dbc.result.getInt("orderId")){
                        ++id;
                        unique = false;
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return id;
    }
    
}
