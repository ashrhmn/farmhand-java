/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmhand;


import Frame.LoginPage;
import Frame.SplashScreen;


/**
 *
 * @author ash
 */
public class Farmhand {

    /**
     * @param args the command line arguments
     */
    static SplashScreen splash;
    public static void main(String[] args) {
        // TODO code application logic here



        splash = new SplashScreen();
        splash.setVisible(true);
        
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                // your code here
                 LoginPage frame = new LoginPage();
                 frame.setVisible(true);
                 splash.setVisible(false);
                 splash.dispose();
                 
            }
        }, 
        1000 
);
        
        
    }
    
}
