package GreedyPractice;

class Solutionū������� {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < number.length() - k; i++) {// ������ �ϴ� ���ڿ��� ����
			int max = 0;
			for (int j = idx; j <= i + k; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			sb.append(max);
		}

		return sb.toString();
	}
}