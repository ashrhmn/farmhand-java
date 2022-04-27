/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

/**
 *
 * @author ash
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {

    Connection con;
    Statement st;
    ResultSet result;
    String connectionType;

    // globalDatabase
//    String server = "remotemysql.com";
//    String databaseName = "QNUpfT15DE";
//    String user = "QNUpfT15DE";
//    String password = "Qn8x3INOgb";
//    String port = "3306";
    
    // localMysqlDatabase
    String server = "localhost";
    String databaseName = "farmHand";
    String user = "jdbc";
    String password = "jdbc";
    String port = "3306";

    public DBconnection() {
        this.connectionType = "mysql";
    }

    public DBconnection(String connectionType) {
        this.connectionType = connectionType;
    }

    public void openConnection() {
        try {
            if (connectionType.equals("sqlite")) {
                try {
                    con = DriverManager.getConnection("jdbc:sqlite:local.db");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (connectionType.equals("mysql")) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + databaseName, user, password);
            }

            st = con.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
            if (result != null) {
                result.close();
            }
            System.out.println("Disconnected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tableInitialize() {
        try {

            if (connectionType.equals("local")) {
                st.execute("CREATE TABLE IF NOT EXISTS 'auth' ('username' TEXT UNIQUE,'password' TEXT,'role' TEXT)");
                st.execute("CREATE TABLE IF NOT EXISTS 'person' ('username' TEXT,'name' TEXT,'mobile' TEXT,'nid' TEXT,'trade' TEXT,'email' TEXT,'dob' TEXT,'address' TEXT,UNIQUE(username,nid,mobile))");
            } else if (connectionType.equals("global")) {
                st.execute("CREATE TABLE IF NOT EXISTS `QNUpfT15DE`.`auth` ( `username` TEXT NOT NULL , `password` TEXT NOT NULL , `role` TEXT NOT NULL ) ENGINE = InnoDB;");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
