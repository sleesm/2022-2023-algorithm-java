package DPPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 다이나믹 프로그래밍
 * 효율적인 화폐구성
 * 참고 : https://hyena.oopy.io/ce66992c-2164-494a-9c47-ec04885e1be0
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
				if(dp[j - nums[i]] != 10001) /*어차피 바뀌기 때문에 넣어도 안 넣어도 되는 조건이다.*/
					dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
			}
		}

		if (dp[m] == 10001)
			System.out.print(-1);
		else
			System.out.print(dp[m]);
	}
}
