package DPPractice;

import java.util.Scanner;

class Main2193 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 sc.close();
		 
		 long[] dp = new long[91];
		 
		 dp[0] = 0L;
		 dp[1] = 1L;
		 for(int i = 2; i<= n; i++) {
			 dp[i] = dp[i-1] + dp[i-2];
		 }
		 System.out.println(dp[n]);
	}
}
