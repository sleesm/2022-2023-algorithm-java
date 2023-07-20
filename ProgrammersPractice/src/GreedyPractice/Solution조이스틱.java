package GreedyPractice;

class Solution���̽�ƽ {
	public int solution(String name) {
		int answer = 0; // ���ĺ� ���� Ƚ��
		int move = name.length() - 1; // �̵� Ƚ��

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