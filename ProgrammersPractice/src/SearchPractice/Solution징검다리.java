package SearchPractice;

import java.util.*;

class Solution징검다리 {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		// left : 바위 사이의 최소 거리, right : 바위 사이의 최대 거리
		// mid : 실제 바위 사이 거리의 최솟값이 될 값
		int left = 1, right = distance, mid = 0;

		while (left <= right) {
			int count = 0;
			int prev = 0; // 거리를 확인할 이전 바위
			mid = (left + right) / 2;
			for (int i = 0; i < rocks.length; i++) {
				// 이전 바위와의 거리가 mid 보다 작으면 바위 삭제
				if (rocks[i] - prev < mid) {
					count++;
				} else { // mid보다 크거나 같은 값은 이전 바위로 변경
					prev = rocks[i];
				}
			}

			// 마지막 돌과 도착지점 사이의 거리 확인
			// 거리가 mid보다 작으면 바위 삭제
			if (distance - prev < mid)
				count++;

			// 최소값 중에 최대값 구하기 - 바위 n개일 때
			// if(count == n){
			// answer = Math.max(answer, mid);

			if (count <= n) { // 바위 n개 이하일 때 <- 이게 정답 처리 되는 걸 보아 문제 오류가 있는 듯!
				answer = Math.max(answer, mid); // mid > answer ? mid : answer;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}
}