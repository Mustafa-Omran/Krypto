/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptive_Huffman_Coding;

/**
 *
 * @author Eslam3bkr
 */


import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Adaptive_Huffman {
    private Object jTextArea1;
    
     public void adaptive_huffman(String input){
         ArrayList<Character>symbol=new ArrayList<>();         
         String newval="0";
         String swapval="";
         String newCode="";
         int index;
         ArrayList<String>newVal=new ArrayList<>();
         char[]inputArray=new char[input.length()];
         ArrayList<Character> finalArray=new ArrayList<>();   
         // Filling the Array with input
         for(int i=0;i<inputArray.length;i++){
             inputArray[i]=input.charAt(i);
         }
         //convert the array to array List
         for(int i=0;i<inputArray.length;i++){
        
            finalArray.add(input.charAt(i));
        }
         //removing repeated characters
         for (int i=0;i<finalArray.size();i++){
            for(int j=i+1;j<finalArray.size();j++){
                if(finalArray.get(i)==finalArray.get(j)){
                    finalArray.remove(j);
                }              
            }          
        } 
         //convertin final array to array
         Character [] toarray=finalArray.toArray(new Character[finalArray.size()]);
         int [] weight=new int[toarray.length];
         String []codes=new String[toarray.length];
         int [] leftWeight=new int[toarray.length+1];
         
         for(int i=0;i<inputArray.length;i++){
             if(symbol.isEmpty()){
                 weight[i]=1;
                 symbol.add(inputArray[i]);
                 newval="0";
                 newVal.add(newval);
                 codes[i]="1";
                 leftWeight[i]=1;
             }else{}
             // check if the character is existing before 
             if(symbol.contains(inputArray[i])){
                 for(int j=0;j<symbol.size();j++){
                     if(symbol.get(j).equals(inputArray[i])){
                         index=j;
                         weight[j]++;
                         for(int k=0;k<=index;k++){
                             leftWeight[k]++;
                         }
                     }
                 }
             }else{ //character not exist before
                 symbol.add(inputArray[i]);
                 newCode=newval+"1";
                 newval=newval+"0";
                 newVal.add(newval);
                 codes[i]=newCode;
                 for(int k=0;k<i;k++){
                      leftWeight[k]++;
                      
                }
             }
            
             
          }
         //conveting newVal arrayList to array
         String[] newToArray=newVal.toArray(new String[newVal.size()]);
         // comparing weight
         for(int x=0;x<weight.length;x++){
                for(int y=0;y<weight.length;y++){
                    if(weight[x]>=weight[y]){                
                         int temp=weight[x];
                         weight[x]=weight[y];
                         weight[y]=temp;
                         String chartemp=codes[x];
                         codes[x]=codes[y];
                         codes[y]=chartemp;
                    
                }
            }
        }
             //comparing the right with left
             
             for(int a=0;a<weight.length;a++){
                 if(leftWeight[a+1]>weight[a]){
                     String temp=codes[a];
                     codes[a]=newToArray[a];
                     newval=codes[a];
                     for(int c=a+1;c<codes.length;c++){
                         
                         codes[c]=codes[a]+newval+"1";
                         newToArray[c-1]=newval;
                         newval=newval+"0";
                     }
                     
                 }
               
//                 JOptionPane.showMessageDialog(null, "the code of \n" +toarray[a]+"\n is "+codes[a]);
             }   
       
         
      for(int i=0;i<codes.length;i++)
      {
         
//            System.out.println("the code of " +toarray[i]+"is "+codes[i]);
      }
      
      String stringCode="";     //for all string code 
      for(int i=0;i<inputArray.length;i++){
          for(int j=0;j<toarray.length;j++){
              if(inputArray[i]==toarray[j]){
                  stringCode=stringCode+codes[j];
                   
              }
          }
      }
      JOptionPane.showMessageDialog(null, "After Encoding  "+stringCode);
      //saving all codes into array list 
       ArrayList<String>codesList=new ArrayList<>();
        codesList.addAll(Arrays.asList(codes));
      
      //decoding
      char currentChar;
      String convertedchar;
      String preDecode="";
      String decode="";
      String string="";
      int index1;
      for(int i=0;i<stringCode.length();i++){
      
          currentChar=stringCode.charAt(i);
          convertedchar =String.valueOf(currentChar);
          decode=decode.concat(convertedchar);
          
          if(codesList.contains(decode)){
          
          }else{
          
              for(int j=0;j<codesList.size();j++){
              
                  if(codesList.get(j).equals(preDecode)){
                  
                      index1=j;
                      string=string+toarray[index1];
                      decode="";
                      i--;
                  }
              }
          }
          
          preDecode=decode;
      }
      string=string+input.charAt(input.length()-1);
      
     // System.out.println("after Decoding " + string);
      
    }
}

