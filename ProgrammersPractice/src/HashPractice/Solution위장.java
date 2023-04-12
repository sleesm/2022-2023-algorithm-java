package HashPractice;

import java.util.*;

class Solution¿ß¿Â {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		Iterator<Integer> it = map.values().iterator();
		int answer = 1;
		while (it.hasNext()) {
			answer *= it.next().intValue() + 1;
		}

		return answer - 1;
	}
}