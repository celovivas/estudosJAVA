package br.com.estudosJAVA.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution5 {

    /*
     * Complete the function below.
     */
    static int differentTeams(String skills) {
    	
    	int cont = 0;
//    	if (skills.length() % 5 == 0){
//    		
//    	}
    	
//    	final String regex = "(p|c|m|b|z){5}";
    	final String regex = "(p|c|m){2}";
    	
		final Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(skills);
		if (skills.length() > 1){
			
			if (matcher.find()) {
				cont = matcher.groupCount();
			}
			
		}
		else {
			cont = 0;
		}
		return cont;
    }
    public static void main(String[] args) throws IOException {
       
        int res;
        String skills = "pmcbzpcmbzpcmbzpc";
        res = differentTeams(skills);
        
        System.out.println(res);
            	
    	
    }
}
