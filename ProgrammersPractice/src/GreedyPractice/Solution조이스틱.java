package GreedyPractice;

class SolutionÁ¶ÀÌ½ºÆ½ {
	public int solution(String name) {
		int answer = 0; // ¾ËÆÄºª º¯°æ È½¼ö
		int move = name.length() - 1; // ÀÌµ¿ È½¼ö

		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			int idx = i + 1;
			while (idx < name.length() && name.charAt(idx) == 'A')
				idx++;

			move = Math.min(move, i * 2 + (name.length() - idx));
			move = Math.min(move, i + (name.length() - idx) * 2);
		}

		return answer + move;
	}
}