package br.com.estudosJAVA.hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minNum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER A
     *  2. INTEGER K
     *  3. INTEGER P
     */

    public static int minNum(int A, int K, int P) {
    // Write your code here
    	int day = 1;
    	int totalA = P;
    	int totalK = 0;
    	
    	if (A >= K){
    		return -1;
    	}
       	
    	if ((A >= 1 && A <= 100) &&
    		(K >= 1 && K <= 100) &&	
    		(P >= 0 && P <= 100)){
    		
    		while (totalK < totalA){
    			totalA = totalA + A;
    			totalK = totalK + K;
    			day++;
    		}
    	}
    	else{
//    		return -1;
    		throw new RuntimeException("Números não permitidos");
    	}
    	
    	return day;
    }

}

public class Solution4 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int A = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int K = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int P = Integer.parseInt(bufferedReader.readLine().trim());
        
      int A = 3;

      int K = 5;

      int P = 5;        

        int result = Result.minNum(A, K, P);
        
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
