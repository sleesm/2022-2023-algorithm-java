package DPPractice;

class Solution도둑질 {
	public int solution(int[] money) {
		int n = money.length;
		int[][] dp = new int[2][n];
		dp[0][0] = dp[0][1] = money[0]; // 첫번째 원소 포함
		dp[1][1] = money[1]; // 첫번째 원소 제외

		for (int i = 2; i < n; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], money[i] + dp[0][i - 2]);
			dp[1][i] = Math.max(dp[1][i - 1], money[i] + dp[1][i - 2]);
		}

		// 첫번째 원소 포함, 마지막 원소 제외  vs 첫번째 원소 제외, 마지막 원소 포함
		return Math.max(dp[0][n - 2], dp[1][n - 1]);
	}
}