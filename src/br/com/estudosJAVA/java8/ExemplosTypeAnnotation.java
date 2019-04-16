package br.com.estudosJAVA.java8;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class ExemplosTypeAnnotation {

	public static void main(String[] args) {

		ExemplosTypeAnnotation exemplo = new ExemplosTypeAnnotation();
		
		
		try {
			System.out.print("Somando com valor null: ");
			System.out.println(exemplo.somar1(null, 20));	
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(exemplo.somar2(null, 20));
		try {
			System.out.println("Somando com valor null: ");
			System.out.println(exemplo.somar2(null, 20));	
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();		}
		

	}
	
	
	
	public Integer somar1(Integer valor1, Integer valor2){
		return valor1 + valor2;
		
	}
	
	public Integer somar2(@Nullable Integer valor1,@Nullable Integer valor2){
		
		return valor1 + valor2;
		
	}	
	
}



