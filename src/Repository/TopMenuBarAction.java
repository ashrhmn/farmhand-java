/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Entity.User;
import Frame.LoginPage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author ash
 */
public class TopMenuBarAction {
    UserRepo ur = new UserRepo();

    public void changePassword(JFrame preFrame,User user) {
        String pass;
        JPasswordField passwordField0 = new JPasswordField();
        JLabel label0 = new JLabel("Old Password :");
        JPasswordField passwordField1 = new JPasswordField();
        JLabel label1 = new JLabel("New Password :");
        JPasswordField passwordField2 = new JPasswordField();
        JLabel label2 = new JLabel("Confirm Password :");
        Object[] obj = {label0, passwordField0, label1, passwordField1, label2, passwordField2};

        int action = JOptionPane.showConfirmDialog(preFrame, obj, "Change Password", JOptionPane.OK_CANCEL_OPTION);
        if (action == JOptionPane.OK_OPTION) {
            String pass0 = new String(passwordField0.getPassword());
            String pass1 = new String(passwordField1.getPassword());
            String pass2 = new String(passwordField2.getPassword());
            if (pass0.equals(user.getPassword())) {
                if (pass1.equals(pass2)) {
                    ur.updatePassword(user.getUserId(), pass1);
                    JOptionPane.showMessageDialog(preFrame, "Password changed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(preFrame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(preFrame, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
