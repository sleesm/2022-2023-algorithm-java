package DPPractice;

class Solution������ {
	public int solution(int[] money) {
		int n = money.length;
		int[][] dp = new int[2][n];
		dp[0][0] = dp[0][1] = money[0]; // ù��° ���� ����
		dp[1][1] = money[1]; // ù��° ���� ����

		for (int i = 2; i < n; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], money[i] + dp[0][i - 2]);
			dp[1][i] = Math.max(dp[1][i - 1], money[i] + dp[1][i - 2]);
		}

		// ù��° ���� ����, ������ ���� ����  vs ù��° ���� ����, ������ ���� ����
		return Math.max(dp[0][n - 2], dp[1][n - 1]);
	}
}