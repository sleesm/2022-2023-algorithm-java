package DPPractice;

import java.util.Scanner;

class Main2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		long[] dp = new long[n + 1];
		dp[1] = a[1];
		if (n > 1) {
			dp[2] = a[1] + a[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = a[i] + Math.max(dp[i - 2], dp[i - 3] + a[i - 1]);
		}
		System.out.println(dp[n]);
	}
}
