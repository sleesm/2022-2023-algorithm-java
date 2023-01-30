package SortPractice;

import java.util.Arrays;

class SolutionH_Index {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, Math.min(citations[i], n - i));
		}

		return answer;
	}
}