package DPPractice;

import java.util.Scanner;

/**
 * 다이나믹 프로그래밍 바닥공사
 */
class Main바닥공사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int[] dp = new int[1001];

		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796;
		}

		System.out.print(dp[n]);
	}
}
