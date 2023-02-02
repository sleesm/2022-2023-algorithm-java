package SortPractice;

import java.util.Arrays;

/**
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 */
class Solution로또의최고순위와최저순위 {

	private int getResult(int c) {
		if (c == 0)
			return 6;
		else
			return 7 - c;
	}

	private boolean check(int[] list, int n) {
		for (int i : list) {
			if (i == n)
				return true;
		}
		return false;
	}

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		int count = 0;
		int zeroCount = 0;
		for (int i = 0; i < 6; i++) {
			if (check(lottos, win_nums[i])) {
				count++;
			}
			if (lottos[i] == 0) {
				zeroCount++;
			}
		}

		answer[0] = getResult(count + zeroCount);
		answer[1] = getResult(count);

		return answer;
	}
}