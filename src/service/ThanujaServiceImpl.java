/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import util.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Thanuja Chamika
 */
public class ThanujaServiceImpl {
    private Connection conn = DBConnect.connect();;
    private PreparedStatement pst;
    
    //adding users to database
    public void addUser(User u) {
        try {
            String query = "INSERT INTO user (username, password)"
                    + " VALUES ( '" + u.getUsername() + "' , '" + u.getPassword()  + "')";

            pst = conn.prepareStatement(query);

            pst.execute(); 
        } catch (SQLException ex) {
            System.out.println("Adding Failed!");
            System.out.println(ex);
        }
    }
    
    //Load data to table
    public ResultSet userTableLoad(javax.swing.JTable table) {
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM USER";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

            return rs;
        } catch (SQLException ex) {
            System.out.println("Table loading faild");
            System.out.println(ex);
        }

        return rs;
    }
    
    //updating users
    public void updateUser(User u){
        try {
            pst = conn.prepareStatement("UPDATE user SET  username = ?, password = ? WHERE id = ? ");
            pst.setString(1, u.getUsername());
            pst.setString(2, Integer.toString(u.getPassword()));
            pst.setString(3, Integer.toString(u.getId()));
            
            pst.execute();
            
        } catch (SQLException ex) {
            System.out.println("Update failed!");
            System.out.println(ex);            
        }
    }
    
    //delete users
    public void deleteUser(String id) {
        try {
            String deleteQuery = "DELETE FROM user WHERE id = '" + id + "'";
            pst = conn.prepareStatement(deleteQuery);
            pst.execute();

        } catch (SQLException ex) {
            System.out.println("Deletion dailed");
            System.out.println(ex);           
        }
    }
}
