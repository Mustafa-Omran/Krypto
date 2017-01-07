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


public class encode_and_decode_run_length {
	
			
	public void encodeRunLength (String word){
		int count = 1;
		word = word.concat("!");
		int length = word.length();		
		
		char [] every_character = new char[length];
		int [] every_character_count = new int[length];
		
		int n = 0;
		for(int x=1 ; x< length ; x++ )
		{
			if(word.charAt(x) == word.charAt(x-1))
			{
				count++;
			}
			else
			{
				every_character[n] = word.charAt(x-1);
				every_character_count[n] = count;
				count = 1;
				n++;
			}						
		}
			 int new_length = 0;
			 
		for(int x=0 ; x<length ; x++)
		{
			if( every_character_count[x] != 0)
			{
				new_length++;
			}						
		}
		
	    char [] new_every_character = new char[new_length];
		int [] new_every_character_count = new int[new_length];
		
		for(int x=0 ; x<length ; x++)
		{
			if( every_character_count[x] != 0)
			{
				new_every_character[x] = every_character[x];
				new_every_character_count[x] = every_character_count[x];
				System.out.print(new_every_character[x]);
				System.out.println(new_every_character_count[x]);
			}
		}
			
		decodeRunLength ( every_character , every_character_count);
	}
	
	
	public void decodeRunLength (char[] every_character , int[] every_character_count){		
		int length = every_character.length;
		String word = "";		
		for(int x=0 ; x<length ; x++)
		{
			if(every_character_count[x] > 1)
			{
				for(int y=0 ; y<every_character_count[x] ; y++)
				{
					word = word+every_character[x];
				}			
			}
			else
			{
				word = word+every_character[x];
			}			
		}
				
		//System.out.println(word);
	}
}
