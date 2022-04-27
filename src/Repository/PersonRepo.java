/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entity.Person;
import Entity.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ash
 */
public class PersonRepo {
    DBconnection dbc;

    public PersonRepo() {
        dbc = new DBconnection();
    }
    
    public Person getPersonDetails(String username){
        Person person = null;
        dbc.openConnection();
            try {
                dbc.result = dbc.st.executeQuery("select * from person where username='"+username+"'");
                if(dbc.result.next()){
                    person = new Person();
                    person.setName(dbc.result.getString("name"));
                    person.setAddress(dbc.result.getString("address"));
                    person.setDateOfBirth(dbc.result.getString("name"));
                    person.setEmail(dbc.result.getString("email"));
                    person.setMobile(dbc.result.getString("mobile"));
                    person.setTradeLicenseNo(dbc.result.getString("tradeLicNo"));
                    person.setNid(dbc.result.getString("nid"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserRepo.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbc.closeConnection();
        return person;
    }
    
    public void setPersonDetails(User user){
        Person person = user.getPerson();
        dbc.openConnection();
        try {
            System.out.println("replace into person values('"+user.getUserId()+"','"+person.getCredit()+"','"+person.getName()+"','"+person.getMobile()+"','"+person.getNid()+"','"+person.getTradeLicenseNo()+"','"+person.getDateOfBirth()+"','"+person.getEmail()+"','"+person.getAddress()+"')");
            dbc.st.executeUpdate("replace into person values('"+user.getUserId()+"','"+person.getCredit()+"','"+person.getName()+"','"+person.getMobile()+"','"+person.getNid()+"','"+person.getTradeLicenseNo()+"','"+person.getDateOfBirth()+"','"+person.getEmail()+"','"+person.getAddress()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(PersonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addNewPerson(String username){
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into person (`username`, `credit`) values('"+username+"',"+0.0+")");
            dbc.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }
    
    
    public boolean removePerson(String username){
        dbc.openConnection();
            try {
                dbc.st.executeUpdate("delete from auth where username='"+username+"'");
                dbc.closeConnection();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UserRepo.class.getName()).log(Level.SEVERE, null, ex);
                dbc.closeConnection();
                return false;
            }
    }
    
    
}
