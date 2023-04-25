package HeapPractice;

import java.util.*;

class Solution이중우선큐 {
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (String s : operations) {
			String[] tmp = s.split(" ");
			if (tmp[0].equals("I")) {
				minQ.offer(Integer.parseInt(tmp[1]));
				maxQ.offer(Integer.parseInt(tmp[1]));
			} else {
				if (tmp[1].equals("1")) {
					if (!maxQ.isEmpty()) {
						int max = maxQ.poll();
						minQ.remove(max);
					}
				} else {
					if (!minQ.isEmpty()) {
						int min = minQ.poll();
						maxQ.remove(min);
					}
				}
			}
		}

		if (minQ.isEmpty())
			return new int[] { 0, 0 };
		else {
			int min = minQ.poll();
			int max = maxQ.poll();
			return new int[] { max, min };
		}
	}
}