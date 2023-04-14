package SearchPractice;

import java.util.*;

/**
 * 이분(이진) 탐색 
 */
class Solution입국심사 {
	public long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times); // 최악의 경우를 찾기 위한 정렬
		long start = 1; // 최선의 경우
		long end = (long) times[times.length - 1] * n; // 최악의 경우

		while (start <= end) {
			long sum = 0;
			long mid = (start + end) / 2;

			// 심사관마다 중간 시간을 기준으로 심사할 수 있는 사람의 수의 합
			// 최적이 되는 때가 정답임
			for (int time : times) {
				sum += mid / time;
			}

			if (sum >= n) { // 심사받을 사람보다 많거나 같은 경우
				end = mid - 1;
				answer = mid;
			} else { // 심사 받을 사람보다 적은 경우
				start = mid + 1;
			}
		}

		return answer;
	}
}