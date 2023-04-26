package GreedyPractice;

class Solution√º¿∞∫π {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++)
			nums[i] = 1;

		for (int i : lost)
			nums[i]--;

		for (int i : reserve)
			nums[i]++;

		for (int i = 1; i <= n; i++) {
			if (nums[i] != 0)
				continue;
			if (i - 1 > 0 && nums[i - 1] == 2) {
				nums[i - 1]--;
				nums[i]++;
			} else if (i + 1 <= n && nums[i + 1] == 2) {
				nums[i + 1]--;
				nums[i]++;
			}
		}

		for (int i : nums) {
			if (i == 2) {
				answer += 1;
			} else
				answer += i;
		}

		return answer;
	}
}