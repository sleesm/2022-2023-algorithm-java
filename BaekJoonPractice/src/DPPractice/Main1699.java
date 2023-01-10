package DPPractice;

import java.util.Scanner;

class Main1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int[] dp = new int[100001];
		
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
		}
		
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
			}
		}
		System.out.println(dp[n]);
	}

}
