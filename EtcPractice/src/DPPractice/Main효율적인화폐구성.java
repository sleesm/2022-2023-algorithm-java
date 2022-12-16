package DPPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 다이나믹 프로그래밍
 * 효율적인 화폐구성
 */
class Main효율적인화폐구성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		sc.close();

		int[] dp = new int[m + 1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = nums[i]; j <= m; j++) {
				dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
			}
		}

		if (dp[m] == 10001)
			System.out.print(-1);
		else
			System.out.print(dp[m]);
	}
}
