package DPPractice;

class Solution사칙연산 {

	private int[] nums;
	private char[] oper;
	private int[][][] dp;

	private int dfs(int sign, int start, int end) {

		if (start == end) {
			dp[sign][start][end] = nums[start];
			return dp[sign][start][end];
		}

		if (sign == 0 && dp[sign][start][end] != Integer.MIN_VALUE)
			return dp[sign][start][end];
		if (sign == 1 && dp[sign][start][end] != Integer.MAX_VALUE)
			return dp[sign][start][end];

		int tmp = (sign == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

		if (sign == 0) {
			for (int i = start; i < end; i++) {
				if (oper[i] == '+')
					tmp = Math.max(tmp, dfs(0, start, i) + dfs(0, i + 1, end));
				else
					tmp = Math.max(tmp, dfs(0, start, i) - dfs(1, i + 1, end));
			}
		} else {
			for (int i = start; i < end; i++) {
				if (oper[i] == '+')
					tmp = Math.min(tmp, dfs(1, start, i) + dfs(1, i + 1, end));
				else
					tmp = Math.min(tmp, dfs(1, start, i) - dfs(0, i + 1, end));
			}
		}
		dp[sign][start][end] = tmp;
		return dp[sign][start][end];
	}

	public int solution(String arr[]) {
		int answer = -1;

		int n = arr.length / 2;
		nums = new int[n + 1];
		oper = new char[n];

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				nums[i / 2] = Integer.parseInt(arr[i]);
			else
				oper[i / 2] = arr[i].charAt(0);
		}

		// dp[0][i][j] : i부터 j까지 계산했을 때 최댓값
		// dp[1][i][j] : i부터 j까지 계산했을 때 최솟값
		dp = new int[2][n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[0][i][j] = Integer.MIN_VALUE;
				dp[1][i][j] = Integer.MAX_VALUE;
			}
		}

		return dfs(0, 0, n);
	}
}