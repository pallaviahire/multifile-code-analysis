/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplefile_server;

import java.util.ArrayList;

/**
 *
 * @author Innovatus Tech
 */
public class PerformerThread extends Thread
{
    public void run()
    {
         System.out.println("Performer Thread Activated");
     
        while(true)
        {
            
            System.out.print(" - ");
         if(!QueueDataKeeper.queue.isEmpty())
            {
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception ex)
                {
                    System.out.println("Exception at sleep "+ex);
                }
                
                   String cont=(String)QueueDataKeeper.queue.remove();  
                    long qrtime=System.nanoTime();
                 QueueDataKeeper.qouttime.add(qrtime);
             if(!cont.startsWith("end"))
             {
                
                 
             
             String st[]=cont.split("@");
             String pname=st[0];
             String pcont=st[1];
               // System.out.println("Removed Program is =========== "+cont);
             long time=new EncryptDecrypt().runCode(pcont); // returns the time taken to encrypt and decrypt single line 
             ArrayList temp=new ArrayList();
             temp.add(pname);
             temp.add(Long.toString(time));
             QueueDataKeeper.programname.add(temp);
             }
             else
             {
                
             QueueDataKeeper.qouttime.add(qrtime);
             String st[]=cont.split("@");
             String pname=st[1];
             String pcont=st[2];
               // System.out.println("Removed Program is =========== "+cont);
             long time=new EncryptDecrypt().runCode(pcont); // returns the time taken to encrypt and decrypt single line
             ArrayList temp=new ArrayList();
             temp.add(pname);
             temp.add(Long.toString(time));
             QueueDataKeeper.programname.add(temp);
             break;
             }
            
             
               
             
            }
       
         
        }
        
        System.out.println("\n\n================================================================================\n\n");
        // System.out.println("Intimew Queue is "+QueueKeeper.qintime);
      //  System.out.println("Outtime Queue is "+QueueKeeper.qouttime);
       // System.out.println("Program name is  "+QueueKeeper.programname);
        
        System.out.println("PROGRAM NAME -- CHARACTER COUNT -- QUEUE IN TIME IN NS -- QUEUE OUTTIME IN NS -- QUEUE WAIT TIME IN NS -- CHARACTER COUNT TIME IN NS");
        System.out.println("\n");
//        int delaytime=10;
        for (int i = 0; i < QueueDataKeeper.programname.size(); i++)
        {
            ArrayList row=(ArrayList)QueueDataKeeper.programname.get(i);
            String pname=(String)row.get(0);
            String chcount=(String)row.get(1);
            long intime=QueueDataKeeper.qintime.get(i);
            long outtime=QueueDataKeeper.qouttime.get(i);
            long total=(outtime)-intime;
            long chtime=QueueDataKeeper.chcounttime.get(i);
            
            System.out.println(pname+" -- "+chcount+" -- "+intime+"  -- "+outtime+" -- "+total+" -- "+chtime);
//            System.out.println("Delay time is "+delaytime);
//            delaytime=delaytime+10;
            
            
        }
                System.out.println("=============================================================================\n\n");
        
    }
    
}
