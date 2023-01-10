package SearchPractice;

import java.util.Scanner;

/**
 * 탐색 문제인데 DP로 해결
 */
class Main1451 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long[][] dp = new long[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String s = sc.next();
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (s.charAt(j - 1) - '0');
			}
		}
		sc.close();


		long max = 0;
		for (int i = 1; i < n; i++) {
			long basedown = dp[n][m] - dp[i][m];
			for (int j = 1; j < m; j++) {
				long left = dp[i][j];
				long right = dp[i][m] - dp[i][j];

				long mul = basedown * left * right;
				max = Math.max(max, mul);
			}

			for (int j = 1; j < i; j++) {
				long up = dp[j][m];
				long down = dp[i][m] - dp[j][m];
				
				long mul = basedown * up * down;
				max = Math.max(max, mul);
			}
			
			long baseup = dp[i][m];
			for(int j = 1; j< m; j++) {
				long left = dp[n][j] - dp[i][j];
				long right = dp[n][m] - dp[i][m] - dp[n][j] + dp[i][j];

				long mul = baseup * left * right;
				max = Math.max(max, mul);
			}
			
		}
		
		for(int j = 1; j< m; j++) {
			long baseleft = dp[n][j];
			for(int i = 1; i< n; i++) {
				long up = dp[i][m] - dp[i][j];
				long down = dp[n][m] - dp[n][j] - dp[i][m] + dp[i][j];
				
				long mul = baseleft * up * down;
				max = Math.max(max, mul);
			}
			
			for(int i = j+1; i< m; i++) {
				long left = dp[n][i] - dp[n][j];
				long right = dp[n][m] - dp[n][i];

				long mul = baseleft * left * right;
				max = Math.max(max, mul);
			}
			
			for(int i = 1; i< n; i++) {
				long baseright = dp[n][m] - dp[n][j];
				long up = dp[i][j];
				long down = dp[n][j] - dp[i][j];
				
				long mul = baseright * up * down;
				max = Math.max(max, mul);
			}
		}
		
		System.out.println(max);
	}

}
