/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplefile_client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Mohit
 */
public class ClientReceiver extends Thread{
    public void run()
    {
     String main="";
        
       
        System.out.println("Recevier Starter");
        try
        {
            ServerSocket s= new ServerSocket(3000);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String ms=dis.readUTF();
          //     System.out.println("Recevied msg is "+ms.length());
               
               if(ms.length()>0)
               {
                   
          
                MainFrame.time=ms;
              
                 
                MainFrame.str=1; 
                      }
                 
     }
            }
        
        catch(Exception e)
        {

        }
       
    }
}
