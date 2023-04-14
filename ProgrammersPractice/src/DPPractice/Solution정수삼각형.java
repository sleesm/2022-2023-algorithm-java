package DPPractice;

class Solution정수삼각형 {
	public int solution(int[][] triangle) {
		int[][] dp = new int[501][501];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
		}

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 1; j < triangle[i].length; j++) {
				if (j == triangle[i].length) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}
			}
		}

		int max = 0;
		for (int j = 0; j < triangle.length; j++) {
			max = Math.max(max, dp[triangle.length - 1][j]);
		}

		return max;
	}
}