package DPPractice;

import java.util.Scanner;

class Main11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int MOD = 10007;
		
		long[][] dp = new long[1001][10];
		
		for(int i=0; i<=9; i++) {
		    dp[1][i] = 1L;
		}
		
		for(int i = 2; i<= n; i++) {
			for(int j = 0; j<= 9; j++) {
				for(int k = j; k<=9; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] = dp[i][j] % MOD;
			}
		}
		
		long result = 0;
		for(int i = 0; i<=9; i++) {
			result = (result + dp[n][i]) % MOD;
		}
		System.out.println(result);
	}
}
