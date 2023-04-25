package StackQueuePractice;

import java.util.*;

class Solution다리를지나는트럭2 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<int[]> readyQ = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			readyQ.offer(new int[] { truck_weights[i], 0 });
		}

		int nowWeight = 0;
		int answer = 1;
		Queue<int[]> moveQ = new LinkedList<>();

		// readyQ와 moveQ 둘 다 empty일때 멈춰지는 것!
		while (!readyQ.isEmpty() || !moveQ.isEmpty()) {

			if (!readyQ.isEmpty() && readyQ.peek()[0] + nowWeight <= weight) {
				int[] tmp = readyQ.poll();
				nowWeight += tmp[0];
				moveQ.offer(tmp);
			}

			for (int[] i : moveQ) {
				i[1]++;
			}

			if (moveQ.peek()[1] == bridge_length) {
				int[] tmp = moveQ.poll();
				nowWeight -= tmp[0];
			}

			answer++;
		}

		return answer;
	}
}