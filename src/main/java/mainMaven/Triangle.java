package mainMaven;

import java.util.HashMap;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=10;
		for(int i=1;i<=row;i++) {
			for(int k=1;k<=row-i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {

			System.out.print("*");
		}
			System.out.println("");

	}

	}
}