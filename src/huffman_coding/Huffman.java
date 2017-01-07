package huffman_coding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
public class Huffman {
    
    public void huffman(String input){

        char [] inputArray=new char[input.length()];
        ArrayList<Character> finalArray=new ArrayList<Character>();      
        int count=0;
        
        //putting input in array
        for (int i=0;i<inputArray.length;i++){
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
            count=0;
        }
       
        //calculating occurance of each character
        Character[]finalToArray=finalArray.toArray(new Character[finalArray.size()]);
        int [] charOccurance=new int[finalToArray.length]; 
        for(int i=0;i<finalToArray.length;i++){
            for(int j=0;j<inputArray.length;j++){
            
                if(finalToArray[i].equals(inputArray[j])){
                
                    count++;
                }
            }
        charOccurance[i]=count;
        count=0;
        }
        
        //sorting the array
                for(int i=0;i<charOccurance.length;i++){
        
            for(int j=0;j<charOccurance.length;j++){
                if(charOccurance[i]>=charOccurance[j]){
                
                    int temp=charOccurance[i];
                    charOccurance[i]=charOccurance[j];
                    charOccurance[j]=temp;
                    char chartemp=finalToArray[i];
                    finalToArray[i]=finalToArray[j];
                    finalToArray[j]=chartemp;
                    
                }
            }
        }

       //determining the code of each character in string 
       String stringCode="";
       String code="0";
       String lastCode="1";
       String [] allcodes=new String[charOccurance.length];
       for(int i=0;i<charOccurance.length-1;i++){
           if(i<charOccurance.length){
               allcodes[i]=code;       
//               JOptionPane.showMessageDialog("the code of " +finalToArray[i]+ " is " +code );
               
          // System.out.println("the code of " +finalToArray[i]+ " is " +code );
           code="1"+code;
           
           }
           // JOptionPane.showMessageDialog(null,"The code of  : "+finalToArray[i]+"Is"+ code+"\n");
       }
       
       
       for(int i=0;i<charOccurance.length-1;i++){
       
           lastCode=lastCode+"1";                      
       }       
     //  System.out.println("the code of " + finalToArray[finalToArray.length-1]+" is " + lastCode);
       allcodes[finalToArray.length-1]=lastCode;

       //find the code for all string
         for(int i=0;i<input.length();i++){
           for(int j=0;j<finalToArray.length;j++){
               if(input.charAt(i)==finalToArray[j]){
                   stringCode=stringCode+allcodes[j];
               
               }
           
           }
       }
         //printing string code
       //System.out.println("the code of all string is "+stringCode);
       JOptionPane.showMessageDialog(null,"The code of Last String is "+finalToArray[finalToArray.length-1] +lastCode+" "+"\n The code of all string is  : "+stringCode);
       //saving all codes into array list 
       ArrayList<String>codes=new ArrayList<String>();
       for(int i=0;i<allcodes.length;i++){
       
           codes.add(allcodes[i]);
       }
       
       //determining parents
       String parent="p";
       String firstParent=""+finalToArray[finalToArray.length-1];
       int parentCounter=1;
       for(int i=finalToArray.length;i>2;i--){
//       JOptionPane.showMessageDialog(null,"The code of  : "+finalToArray[i]+"Is"+ code+"\n");
        //   System.out.println(parent + " is the parent of " +
                //   firstParent + " and "+ finalToArray[i-2]);
           firstParent=parent;
           parent="p";
           parent=parent+parentCounter;
           parentCounter++;
           
           
       }
       
       //decoding
      char currentChar;
      String convertedchar;
      String preDecode="";
      String decode="";
      String string="";
      int index;
      for(int i=0;i<stringCode.length();i++){
      
          currentChar=stringCode.charAt(i);
          convertedchar =String.valueOf(currentChar);
          decode=decode.concat(convertedchar);
          
          if(codes.contains(decode)){
          
          }else{
          
              for(int j=0;j<codes.size();j++){
              
                  if(codes.get(j).equals(preDecode)){
                  
                      index=j;
                      string=string+finalToArray[index];
                      decode="";
                      i--;
                  }
              }
          }
          
          preDecode=decode;
      }
      string=string+input.charAt(input.length()-1);
              
   //   System.out.println("after Decoding " + string);
      
      //entropy
      double entropy=0;
      double P;
      double currentEntropy=0;
      for(int i=0;i<charOccurance.length;i++){
          P=(double)charOccurance[i]/(double)charOccurance.length;
          currentEntropy=(P*(Math.log10(P)/Math.log10(2)));
          entropy=entropy+currentEntropy;
          P=0;
          
          
          
      }
      entropy=-entropy;
      //System.out.println("entropy "+entropy);
      
       
    }
}
