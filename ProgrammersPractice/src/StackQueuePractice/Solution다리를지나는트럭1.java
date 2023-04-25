package StackQueuePractice;

import java.util.*;

class Solution다리를지나는트럭1 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			list.add(new int[] { truck_weights[i], 0 });
		}

		int nowWeight = 0;
		int idx = 0;
		int answer = 1;
		ArrayList<int[]> inCarList = new ArrayList<>();
		while (true) {
			if (idx < truck_weights.length) {
				int[] now = list.get(idx);
				if ( now[0] + nowWeight <= weight) {
					inCarList.add(now);
					nowWeight += now[0];
					idx++;
				}
			}

			Iterator<int[]> it = inCarList.iterator();
			int[] removeTmp = null;
			while (it.hasNext()) {
				int[] tmp = it.next();
				if ((tmp[1] + 1) == bridge_length) {
					removeTmp = tmp;
					nowWeight -= tmp[0];
				} else {
					tmp[1]++;
				}
			}
			inCarList.remove(removeTmp);

			answer++;
			if (inCarList.size() == 0 && idx >= truck_weights.length)
				break;
		}

		return answer;
	}
}