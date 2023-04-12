package HashPractice;

import java.util.*;

class Solutionº£½ºÆ®¾Ù¹ü {
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}

		ArrayList<String> genre = new ArrayList<>();
		for (String s : map.keySet()) {
			genre.add(s);
		}
		Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));

		ArrayList<int[]> result = new ArrayList<>();
		for (String s : genre) {
			ArrayList<int[]> list = new ArrayList<>();
			for (int i = 0; i < genres.length; i++) {
				if (s.equals(genres[i])) {
					list.add(new int[] { plays[i], i });
				}
			}
			Collections.sort(list, (o1, o2) -> o2[0] - o1[0]);
			result.add(list.get(0));
			if (list.size() > 1) {
				result.add(list.get(1));
			}
		}

		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i)[1];
		}

		return answer;
	}
}