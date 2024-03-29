package DPPractice;

import java.util.Scanner;

/**
 * 다이나믹 프로그래밍
 * 개미 전사
 */
public class Main개미전사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[101];
		
		for(int i = 1; i<= n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		dp[1] = arr[1];
		for(int i = 2; i <= n; i++) {
			dp[i]  = Math.max(dp[i-2] + arr[i], dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}
