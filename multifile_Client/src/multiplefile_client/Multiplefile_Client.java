/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplefile_client;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Innovatus Tech
 */
public class Multiplefile_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          ClientReceiver rr=new ClientReceiver();
          rr.start();
          
        MainFrame l = new MainFrame();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        l.setVisible(true);
        l.setSize(510,360);
        l.setLocation(500, 150);
        
        
         
        
          
    }
    
}
