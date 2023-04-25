package StackQueuePractice;

class Solution주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int idx = 0;
		while (idx < prices.length) {
			for (int i = idx + 1; i < prices.length; i++) {
				if (prices[idx] > prices[i]) {
					answer[idx] = (i - idx);
					break;
				}
			}
			if (answer[idx] == 0) {
				answer[idx] = (prices.length - 1 - idx);
			}
			idx++;
		}

		return answer;
	}
}