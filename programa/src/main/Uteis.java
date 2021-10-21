package main;

import java.util.Scanner;

public class Uteis {
	private static Scanner sc =new Scanner(System.in);
	
	public static String Input(String msg) {
		//Scanner sc=new Scanner(System.in);
		System.out.print(msg);
		String str = sc.nextLine();
		//sc.nextLine();
		//sc.close();
		return str;
	}
	
}
