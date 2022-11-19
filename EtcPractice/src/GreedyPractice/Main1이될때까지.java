package GreedyPractice;

import java.util.Scanner;

/**
 * 그리디 
 * 1이 될 때까지
 * 2018 E 기업 알고리즘 대회
 */
class Main1이될때까지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		int count = 0;
		while(true) {
			if(n % k == 0)
				n = n/k;
			else
				n--;
			count++;
			if(n < k)
				break;
		}
		count += (n-1);
		
		System.out.println(count);
	}
}
