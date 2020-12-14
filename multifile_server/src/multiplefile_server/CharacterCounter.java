/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multiplefile_server;

import java.util.Queue;


public class CharacterCounter 
{

    public int getCharacterCount(String codestr)
    {
        
        long t1=System.nanoTime();
        int count=0;
           for (int i = 0; i < codestr.length(); i++) 
                {
                
                     char ch=codestr.charAt(i);
                     
                     int x=(int)ch;
                     
                     
                     if((x>=97 && x<=122) ||  (x>=65 && x<=90))
                     {
                         
                         count++;
                         
                     }
                   
                }
           
           long t2=System.nanoTime();
           
           long total=t2-t1;
           QueueDataKeeper.chcounttime.add(total);
           
           return count;
    }
}
