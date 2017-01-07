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
    
import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
//		 TODO Auto-generated method stub 
		en_de_run_length nn = new en_de_run_length();
		
		Scanner x = new Scanner(System.in);
                String word = x.next();
		nn.encodeRunLength(word);

	}

}

