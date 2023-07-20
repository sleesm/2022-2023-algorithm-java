package GreedyPractice;

import java.util.Scanner;

/**
 * 그리디 
 * 1이 될 때까지
 * 2018 E 기업 알고리즘 대회
 */
class Main1이될때까지 {

	/**
	 * using Dynamic Programming
	 */
	static int anotherSolution(int n, int k) {
		int[] dp = new int[100001];
		dp[1] = 0;
		for(int i = 2; i<= n; i++) {
			dp[i] = dp[i -1] + 1;
			if(i%k == 0) {
				dp[i] = Math.min(dp[i/k] + 1 , dp[i]);
			}
		}
		return dp[n];
	}
	
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
