package DPPractice;

import java.util.Scanner;

class Main11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i<= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		System.out.print(dp[n]);
	}
}
