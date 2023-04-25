package HeapPractice;

import java.util.*;

class Solution´õ¸Ê°Ô {

	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int i = 0; i < scoville.length; i++) {
			q.offer(scoville[i]);
		}

		while (true) {
			int first = q.poll();
			if (first >= K)
				break;
			if (first < K && q.size() == 0)
				return -1;

			int second = q.poll();
			int next = (first + second * 2);
			q.offer(next);
			answer++;
		}

		return answer;
	}
}