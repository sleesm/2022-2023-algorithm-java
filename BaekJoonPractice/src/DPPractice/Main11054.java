package DPPractice;

import java.util.Scanner;

class Main11054 {

	static int[] checkPlus(int[] a, int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (a[i] > a[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	static int[] checkMinus(int[] a, int n) {
		int[] dp = new int[n + 1];
		for (int i = n; i > 0; i--) {
			dp[i] = 1;
			for (int j = n; j > i; j--) {
				if (a[i] > a[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();

		int[] dpl = checkPlus(a, n);
		int[] dpr = checkMinus(a, n);

		int result = 0;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, dpl[i] + dpr[i]-1);
		}
		System.out.println(result);
	}

}
