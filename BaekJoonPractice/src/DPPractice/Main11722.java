package DPPractice;

import java.util.Scanner;

class Main11722 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		int[] dp = new int[n+1];
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for(int j = 1; j< i; j++) {
				if(a[i] < a[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

}
