package br.com.estudosJAVA.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Solution2 {


    public static void main(String[] args) throws Exception {
//        Scanner scan = new Scanner(System.in);
//        int i = scan.nextInt();
//
//        // Write your code here.
//        double d = Double.parseDouble(scan.next());
//        scan.nextLine();
//        String s = scan.nextLine();
//
//        System.out.println("String: " + s);
//        System.out.println("Double: " + d);
//        System.out.println("Int: " + i);
        
        Solution2 s2 = new Solution2();
        
        System.out.println(s2.err());
        
    }
    
    
    int err() throws Exception{
    	
    	try {
			throw new IOException("...");
    	}
		catch (RuntimeException e) {
			throw new RuntimeException("rrrr");
		} 
//    	finally {
//			return -1;
//		}
    }

}
