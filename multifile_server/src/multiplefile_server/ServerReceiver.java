/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplefile_server;

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
public class ServerReceiver extends Thread{
    
    public static String clientip=null;
    public void run()
    {
        long t1 = 0,t2=0;
        
       
        System.out.println("Server Started");
        try
        {
            ServerSocket s= new ServerSocket(1254);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String rstr=dis.readUTF();
            //   System.out.println("Recevied msg is "+ms.length());
                
                if(rstr.startsWith("start"))
                {
                    String st[]=rstr.split("@");
                    clientip=st[1].trim();
                    String pname=st[2].trim();
                
                    String pcont=st[3].trim();
                    String msg=pname+"@"+pcont;
                    long qintime=System.nanoTime();
                    t1=qintime;
                    QueueDataKeeper.qintime.add(qintime);
                    QueueDataKeeper.queue.add(msg);
                       // System.out.println("Recieved Program "+pname);
                   // System.out.println("Q "+QueueKeeper.queue);
                    
                }
                else if(rstr.startsWith("end"))
                {
                    String st[]=rstr.split("@");
                    String pname=st[1].trim();
                    String pcont=st[2].trim();
                     String msg="end@"+pname+"@"+pcont;
                     
                     long qintime=System.nanoTime();
                     t2=qintime;
                    QueueDataKeeper.qintime.add(qintime);
                    QueueDataKeeper.queue.add(msg);
                   //  System.out.println("Recieved Program "+pname);
                    
                    //  System.out.println("Q "+QueueKeeper.queue);
                    long total=t2-t1;
                 ServerSender sse=new ServerSender();
                 sse.sendData(Long.toString(total), clientip);
//                 
                }
                else
                {
                     String st[]=rstr.split("@");
                    String pname=st[0].trim();
                    String pcont=st[1].trim();
                     String msg=pname+"@"+pcont;
                      long qintime=System.nanoTime();
                      
                    QueueDataKeeper.qintime.add(qintime);
                   QueueDataKeeper.queue.add(msg);
                      //  System.out.println("Recieved Program "+pname);
                   // System.out.println("Q "+QueueKeeper.queue);
                }
               
              
               
               
         
//                
//                long t1=System.nanoTime();
//             
//                long t2=System.nanoTime();
//                
//                long tr=t2-t1;
                
//                System.out.println("Count of Alphabets is "+count);
//                 System.out.println("Execution Time is "+count);
                 
//                 String con=count+"@"+tr;
//                 
//             
                 
                 
     }
            }
        
        catch(Exception e)
        {
            System.out.println("Exception at ServerReceiver class "+e);
        }
       
    }
}
