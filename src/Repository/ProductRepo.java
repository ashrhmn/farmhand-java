/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ash
 */
public class ProductRepo {

    DBconnection dbc;
    public ProductRepo() {
        dbc = new DBconnection();
    }
    
    public ArrayList<Product> allAvailableProduct(){
        ArrayList<Product> products = new ArrayList<>();
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from itemsPrice");
            while(dbc.result.next()){
                Product product = new Product();
                product.setName(dbc.result.getString("item"));
                product.setCategory(dbc.result.getString("category"));
                product.setPrice(dbc.result.getDouble("unitPrice"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return products;
    }
    
    public boolean updateProduct(Product product){
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into itemsPrice values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')");
            dbc.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }
    
    public boolean deleteProduct(Product product){
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("delete from itemsPrice where item='"+product.getName()+"'");
            dbc.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }
    
}
