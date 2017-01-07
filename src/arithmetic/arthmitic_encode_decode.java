/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

/**
 *
 * @author Eslam3bkr
 */
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;


public class arthmitic_encode_decode {

	 ArrayList<Character> every_character = new ArrayList<Character>();
       	 ArrayList<Integer> every_character_count = new ArrayList<Integer>();
	 ArrayList<Double> propabilty = new ArrayList<Double>();
	 ArrayList<Double> chars_range = new ArrayList<Double>();
	 ArrayList<Double> new_low = new ArrayList<Double>();
	 ArrayList<Double> new_high = new ArrayList<Double>();
	 ArrayList<Double> new_range = new ArrayList<Double>();
	 ArrayList<Integer> code = new ArrayList<Integer>();
	 ArrayList<Character> word_letters = new ArrayList<Character>(); 
	 int index;
	 public Integer get_index(){
		 return this.index;
	 }
	 
	 DecimalFormat df = new DecimalFormat("###.####");
	 
	 
	  	//function to prepare program for input string
		 public void input_caharacters (String alpha)
		 {		
			 //initial value for ranges array
			 chars_range.add(0.0);			 
			 //length of inputed string
			 int length = alpha.length();
			 //count of every character
			 int count = 1;
			 //counts range of every character
			 double range = 0.0;
			 
			 //loop throw the whole string
			 for(int x=0 ; x<length ; x++)
			 {
				 //ensure the current character is not taken before 
				 if(!every_character.contains(alpha.charAt(x)))
				 {
					 //loop throw the remaining characters 
					 for(int y=x+1 ; y<length ; y++)
					 {
						 //increase count when found similar character
						 if(alpha.charAt(x) == alpha.charAt(y))
						 {
							 count++;						
						 }
					 }
					 //add current character to the array list
					 every_character.add(alpha.charAt(x));
					 //add count of every character 
					 every_character_count.add(count);
					 
					 double new_count = (double)count;
					 double new_length = (double)length;
					 //count new range = old range + propabilty of current character
					 range = range + (new_count/new_length);
					 range = Math.round(range*100.0)/100.0;
					 //insert propablity int the array list 
					 propabilty.add((new_count/new_length));
					 //insert new range for current character
					 chars_range.add(range);				
					 //re-initiate the counter 
					 count = 1;
				 }				 
			 }
                        
			 JOptionPane.showMessageDialog(null, every_character+"\n"+every_character_count+"\n"+propabilty+"\n"+chars_range);
//			 System.out.println(every_character);
//			 System.out.println(every_character_count);
//			 System.out.println(propabilty);
//			 System.out.println(chars_range);
		 }
		 
		 /********
		  * 
		  * @param word
		  * @return
		  */
		 public boolean check_for_input_string (String word)
		 {
			 int length = word.length();
			 
			 for(int x=0 ; x<length ; x++)
			 {
				 if(!every_character.contains(word.charAt(x)))
				 {
					 return false;
				 }
			 }
			 return true;
		 }
		 
		 /*******
		  * 
		  * @param word
		  */
		 public void get_new_low_high_range(String word)
		 {
			 double low = 0.0;
			 double high = 1.0;
			 double range = 1.0;
			 int length = word.length();			 			
			 
			 for(int x=0 ; x<length ; x++)
			 {
				 char symbol = word.charAt(x);
				 
				 int index = every_character.indexOf(symbol);
				 
				 double old_low = chars_range.get(index);
				 double old_high = chars_range.get(index+1);
				
				 high = low + (range*old_high);
				 low = low + (range*old_low);
				 
				 range = high - low;
				 
				 new_low.add(low);
				 new_high.add(high);				
				 new_range.add(range);				 				 
			 }
			  JOptionPane.showMessageDialog(null, new_low+"\n"+new_high+"\n"+propabilty+"\n"+new_range);
//			 System.out.println(new_low);
//			 System.out.println(new_high);
//			 System.out.println(new_range);			 		
			 
			 generate_code(new_low.get(length-1) , new_high.get(length-1));			 			 			 			 			 
			 
		 }
		 
		 
		 /******* value function
		  * 
		  */
		 public double value(ArrayList<Integer> code)
		 {
			 int power = -1;
			 double val = 0.0;
			 for(int bit : code)
			 {
				 val = val + (bit * Math.pow(2.0,power));
				 power--;
			 }
			 
			 return val;
		 }
		 
		 
		 
		 /*******
		  * generate code
		  * @param a
		  * @param b
		  */		 
		 public void generate_code(double a , double b)
		 {
			 code.add(0);
			 int index=0;
			 
			 while(true)
			 {			
				 if(a <= value(code) && value(code) < b)
				 {
					 //return value(code);
					 break;
				 }
				 
				 if(value(code) < a)
				 {
					 code.add(1); 
				 }				 
				 
				 if(value(code) > b)
				 {							 
			        try
			        {
			    		 code.remove(index);			    		 
					     code.add(0);
					}
			        catch (Exception e) {
						// TODO: handle exception												
						if(e.toString().equals("java.lang.IndexOutOfBoundsException: Index: "+index+", Size: "+index))
						{
							code.add(0);
						}								
					}					 				 					 					 
				 }
				 
				 index++;				 
			 }			 		
			// System.out.println(code);
                         JOptionPane.showMessageDialog(null,"Arthmetic_decode"+code);
			 arthmetic_decode(every_character ,  chars_range , code);
		 }
		 
		 
		 /**********
		  * 
		  * @param a
		  * @param b
		  */
		 public void generate_code2 (double a , double b)
		 {
			 double top = 1.0;
			 double down = 0.0;
			 double middle = 0.5;
			 			 
			 while(true)
			 {
				 if(a < middle && middle < b)
				 {
					 break;
				 }
				 
				 if(a>middle)
				 {
					 down = middle;
					 middle = ((top-down)/2)+down;
					 code.add(1);
				 }
				 else
				 {
					 top = middle;
					 middle = ((top-down)/2)+down;
					 code.add(0);
				 }				 				
			 }
			 			 
			// System.out.println(code);
			 
			 arthmetic_decode(every_character ,  chars_range , code);
			 
		 }
		 
		 
		 /********
		  * 
		  * @param every_character
		  * @param range
		  */		 
		 public void arthmetic_decode(ArrayList<Character> every_character , ArrayList<Double> range , ArrayList<Integer> code)
		 {
			//convert binary code to decimal
			 int length = every_character.size();
			 
			 Double decimal_value = value(code);
			 
			// System.out.println(decimal_value);
			 
			 double low = 0.0;
			 double high = 1.0;
			 double new_range;
		
			 while(true)
			 { 				 				
				 for(int x=0 ; x<length ; x++)
				 {
					 if(range.get(x) <= decimal_value && decimal_value < range.get(x+1))
					 {
						 word_letters.add(every_character.get(x));						 
						 index = x;
						 break;
					 }				 
				 }
				 
				 				
				 low = range.get(get_index());
				 high =  range.get(get_index()+1);
				 new_range = high - low;
				 decimal_value = (decimal_value - low)/new_range;				 				
				 
				 if(word_letters.contains('e'))
				 {
					 break;
				 }						 
			 }
			 JOptionPane.showMessageDialog(null,"\n"+word_letters);			
			// System.out.println(word_letters);
		 }
                
		 
}

