/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw;

/**
 *
 * @author Eslam3bkr
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mahameho
 */
public class Lzw {
 
    static String getS = "";
    ArrayList<Integer> getOutput = new ArrayList<Integer>();
    //////////////////////////////////////
    
    
     String x;
        Character a,b;
        int count=0,index=0,count2=0;
        String s="",c="",d="";
        ArrayList<String>stringat2=new ArrayList<String>();
        ArrayList<String> stringat=new ArrayList<String>();
        ArrayList<Integer>counter=new ArrayList<Integer>();
         ArrayList<Integer>counter2=new ArrayList<Integer>();
        ArrayList<Integer>output=new ArrayList<Integer>();
         ArrayList<String>output2=new ArrayList<String>();
    
    
    //////////////////////
    
    public void encodeLZW(String x){
        
        
         for(int i=0;i<x.length();i++)
        {
             a=x.charAt(i);
         s=String.valueOf(a);
         if(!(stringat.contains(s)))
         {
             stringat.add(s);
             stringat2.add(s);
             count++;
             counter.add(count);
             count2++;
             counter2.add(count2);
         }
        }
        
        /////////////////////////////////////
         a=x.charAt(0);
         s=String.valueOf(a);
        for(int i=1;i<x.length();i++)
        {
            b=x.charAt(i);
         c=String.valueOf(b);
         d=s.concat(c);
            if(stringat.contains(d))
            {
                s=s.concat(c);
            }
            else
            {
                for(int j=0; j<stringat.size();j++)
                {
                    if(s.equals(stringat.get(j)))
                    {
                        index=j;
                        break;
                    }
                }
                output.add(counter.get(index));
                stringat.add(d);
                count++;
                counter.add(count);
                s=c;
            }
        }
      //  System.out.println("s="+s);
  
          getS = s;
               for(int j=0; j<stringat.size();j++)
                {
                    if(s.equals(stringat.get(j)))
                    {
                        index=j;
                        break;
                    }
                }
                output.add(counter.get(index));
                 //  System.out.println("output is:");
                for(int l:output)
                {
                  //  System.out.println(l);
                   getOutput.add(l);
                }
        
        
    }
    
    
    
    public void decompress(){
        
        
        s=null;
               
                for(int i=0;i<output.size();i++)
                {
                    int u=output.get(i);
                    for(int j=0;j<counter2.size();j++)
                    {
                        if(u==counter2.get(j))
                        {
                            index=j;
                            break;
                        }
                    }
                   String w= stringat2.get(index);
                   // System.out.println(w);
                   output2.add(w);
                    if(s!=null)
                    {
                        char l=w.charAt(0);
                        String temp=String.valueOf(l);
                        s=s.concat(temp);
                        
                        stringat2.add(s);
                        count2++;
                        counter2.add(count2);
                    }
                    s=w;
                }
                for(int z=0;z<output2.size();z++)
                {
                   // System.out.print(output2.get(z)+" ");
                }
              //  System.out.println();
        
        
    }
    
    
    
    public String getS(){
        
        return getS;
    }
    
    public ArrayList<Integer> getOutput(){
        
        
        return getOutput;
    }
    
    
    public ArrayList<String> getOutput2(){
        
        return output2;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        /////take a string from user //////////////////
      // Scanner m=new Scanner(System.in);
      //  x=m.next();
        ///////////////////////////////////////
       
                /////////////////////////////decompress///////////////////////
                
    }
    
}

