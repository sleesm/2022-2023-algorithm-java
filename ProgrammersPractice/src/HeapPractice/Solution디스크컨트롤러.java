package HeapPractice;

import java.util.*;

class Solution디스크컨트롤러 {
	public int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int time = 0;
		int idx = 0;
		int count = 0;

		while (count < jobs.length) {

			while (idx < jobs.length && jobs[idx][0] <= time) {
				q.offer(jobs[idx++]);
			}

			if (q.isEmpty()) {
				time = jobs[idx][0];
			} else {

				int[] tmp = q.poll();
				answer += (tmp[1] + time - tmp[0]);
				time += tmp[1];
				count++;
			}
		}

		return (int) (answer / jobs.length);
	}
}