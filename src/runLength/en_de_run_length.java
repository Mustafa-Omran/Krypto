/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runLength;

/**
 *
 * @author Eslam3bkr
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class en_de_run_length {
	
	ArrayList<Character> every_character = new ArrayList<Character>();
	ArrayList<Integer> every_character_count = new ArrayList<Integer>();
	
	public void encodeRunLength (String word) {
		int count = 1;
		word = word.concat("!");
		int length = word.length();				
		
		for(int x=1 ; x< length ; x++ )
		{
			if(word.charAt(x) == word.charAt(x-1))
			{
				count++;
			}
			else
			{
				every_character.add(word.charAt(x-1));
				every_character_count.add(count);
				count = 1;				
			}						
		}
	
		//System.out.println(every_character);
		//System.out.println(every_character_count);
                
		String decode = decodeRunLength(every_character, every_character_count);
                              
               JOptionPane.showMessageDialog(null,"String : "+word+"\n ************\n"+"Encoding is :\n"+ every_character+"\n"+every_character_count+"\nDecoding is :\n"+decode);
                
	}
	
	
	public String decodeRunLength (ArrayList<Character> every_character , ArrayList<Integer> every_character_count){
		int length = every_character.size();
		String word = "";
		
		for(int x=0 ; x<length ; x++)
		{
			if(every_character_count.get(x) > 1)
			{
				for(int y=0 ; y<every_character_count.get(x) ; y++)
				{
					word = word+every_character.get(x);									
				}			
			}
			else
			{
				word = word+every_character.get(x);
			}			
		}
		//System.out.println(word);
                return word;
		
		//System.out.println(word);
		
	}
	

}

