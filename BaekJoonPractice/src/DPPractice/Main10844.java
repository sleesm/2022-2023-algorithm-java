package DPPractice;

import java.util.Scanner;

class Main10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int MOD = 1000000000;
		long[][] dp = new long[101][10];
		
		dp[1][0] = 0L;
		for(int i=1; i<=9; i++) {
		    dp[1][i] = 1;
		}

		for(int i = 2; i<= n; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1; j< 9; j++) {
				dp[i][j] = ( dp[i-1][j-1]+ dp[i-1][j+1]) % MOD;
			}
			dp[i][9] = dp[i-1][8];
		}

		System.out.println();
		long result = 0;
		for(int i = 0; i<=9; i++) {
			result = (result + dp[n][i]) % 1000000000;
		}
		System.out.println(result);
	}
}