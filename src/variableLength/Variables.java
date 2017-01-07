/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variableLength;

/**
 *
 * @author Eslam3bkr
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Basma
 */
public class Variables {

    
    ArrayList<Character> decodedText=new  ArrayList<Character>();
    ArrayList<String> decodedText2=new  ArrayList<String>();
    ////////////////////////////
    
    String finalstring="",temp="",dec="";
       boolean temp2=false;
        int len,count=0,check=0,length,max=0,index=0,checker=0,tt=0;
        Character a,b,c;
        ArrayList<Character> arr=new  ArrayList<Character>();
         ArrayList<Character> alpha=new  ArrayList<Character>();
          ArrayList<Integer> counter=new  ArrayList<Integer>();
            ArrayList<Character> sorting=new  ArrayList<Character>();
             ArrayList<String> code=new  ArrayList<String>();
    
    ////////////////////////////
    
    
    
    
    
    public String encodeText(String x){
        
        
        
        //getting the length of the string
         len=x.length();
        //number of occurs of each character
        for(int i=0;i<len;i++)
        {                                
            count=0;
            a=x.charAt(i);
            if(!(arr.contains(a)))
            {
                 arr.add(a);
            }
        }
        
            for(int i=0;i<arr.size();i++)
            {
                count=0;
                a=arr.get(i);
                for(int j=0;j<x.length();j++)
                {
                    b=x.charAt(j);
                      if(a.equals(b))
                        {
                             count++;
                 
                       }
                }
                // System.out.println(a+" "+count);
                 alpha.add(a);
                 counter.add(count);
            }
            ////creating a tree for the string //////////////
            length=counter.size()-1;
           // System.out.println(length);
            String[][]tree=new String[length][2];
            for(int i=0;i<tree.length;i++)
            {
                for(int j=0;j<tree[i].length;j++)
                {
                    if(j==0)
                        tree[i][j]="0";
                    else if(j==1)
                          tree[i][j]="1";
                    
                    
                }
                
            }
            
           
            
            /////////////////////////////////////
            int lena=counter.size();
            for(int i=0;i<lena;i++)
            {
                   int x2= sorted(counter);
                  sorting.add(alpha.get(x2));
                   counter.remove(x2);
                   alpha.remove(x2);
            }
           for(int i=0;i<sorting.size();i++)
           {
               String s1=printed(i,sorting,tree);
               code.add(s1);
           }
           for(int i=0;i<x.length();i++)
           {
               c=x.charAt(i);
               for(int j=0;j<sorting.size();j++)
               {
                   if(c.equals(sorting.get(j)))
                   {
                       index=j;
                       break;
                   }
               }
               finalstring=finalstring.concat(code.get(index));
           }
            
            // System.out.println("final encode "+finalstring);
             
             return finalstring;
        
    }
    
    
    
    public void decodeText(){
        
         ///////////////////decode //////////////////////// 
           //  System.out.println("Decode:");
             for(int i=0;i<finalstring.length();i++)
             {
                 c=finalstring.charAt(i);
                 temp=String.valueOf(c);
                 dec=dec.concat(temp);
            
                 
                 if(code.contains(dec))
                 {
                     
                      checker=1;
                   
                      tt=1;
                      index=i;
                 }
                else 
                 {
                       checker=0;
                 }
                 if(checker==0&&tt==1)
                 {
                    
                     dec=encode(dec);
                     printed2(dec,sorting,code);
                     tt=0;
                     dec="";
                     i=i-1;
                 }
                 else if(tt==1&&index==(finalstring.length()-1))
                         {
                              printed2(dec,sorting,code);
                                  tt=0;
                                  dec="";
                               //   System.out.println();
                         }
                 
             }
           
       // 
        for(Character m:sorting)
        {
            // System.out.println(m);
           decodedText.add(m);
        }
         for(String m:code)
        {
             //System.out.println(m);
            decodedText2.add(m);
        }
        
        
    }
    
    
    public ArrayList<Character> getSorting(){
        
        return decodedText;
    }
    
    public ArrayList<String> getCoding(){
        
        return decodedText2;
    }
    
    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        // TODO code application logic here
      
          
           //getting the String from user
        //Scanner s=new Scanner(System.in);
        //System.out.println("Enter the string");     ///////////////////
        
        
        
            
        
    }
    public static int sorted(ArrayList<Integer>x)
    {
        int max,a,index;
         max=x.get(0);
         index=0;
        for(int i=0;i<x.size();i++)
        {
            a=x.get(i);
            if(a>max)
            {
                max=a;
                index=i;
            }
        }
        
        return index;
    }
    public static String printed(int l,ArrayList<Character>x,String[][]tree)
    {
        String s="";
        int m,check=0;
         m=x.size()-1;
        if (l==0)
            s=tree[0][0];
        else if(l==m)
        {
            
              for(int  i=0;i<tree.length;i++)
              {
                  for(int j=0;j<tree[i].length;j++)
                  {
                      if(j==1)
                       s=s.concat(tree[i][j]);
                  }
              }
        }
        else
        {
           // System.out.print(x.get(l));
            for(int i=0;i<tree.length;i++)
            {
                
                for(int j=0;j<tree[i].length;j++)
                {
                    //System.out.println(i+" "+j);
                    if(j==1)
                    {
                        s=s.concat(tree[i][j]);
                    }
                   
                        if(i==l&&j==0)
                        {
                         s=s.concat(tree[i][j]);
                        check=1;
                        break;
                        }
                }
                 if(check==1)
                     break;
                
            }
          //  System.out.println("");
        }
          //  System.out.println(s);
            return s;
    }
    public static String encode(String x)
    {
        char c;
        String temp="",dec="";
        for(int i=0;i<(x.length()-1);i++)
        {
            c=x.charAt(i);
             temp=String.valueOf(c);
              dec=dec.concat(temp);
        }
        
        return dec;
    }
    public static void printed2(String x,ArrayList<Character> sort , ArrayList<String> code)
    {
        int index=0;
        for(int i=0;i<code.size();i++)
        {
            if(x.equals(code.get(i)))
            {
                index=i;
                break;
            }
        }
       // System.out.print(sort.get(index));
    }
}

