package ImplementationPractice;

import java.util.Scanner;

/**
 * 그리디 
 * 시각
 */
class Main시각 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int count = 0;
		for(int i = 0; i < n+1; i++)
			for(int j = 0; j<60; j++)
				for(int k = 0; k<60; k++) {
					String tmp = Integer.toString(i) + Integer.toString(j)+ Integer.toString(k);
					if(tmp.contains("3"))
						count++;
				}
		System.out.println(count);
	}
}
