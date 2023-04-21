package SearchPractice;

import java.util.*;

class Solution¡�˴ٸ� {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		// left : ���� ������ �ּ� �Ÿ�, right : ���� ������ �ִ� �Ÿ�
		// mid : ���� ���� ���� �Ÿ��� �ּڰ��� �� ��
		int left = 1, right = distance, mid = 0;

		while (left <= right) {
			int count = 0;
			int prev = 0; // �Ÿ��� Ȯ���� ���� ����
			mid = (left + right) / 2;
			for (int i = 0; i < rocks.length; i++) {
				// ���� �������� �Ÿ��� mid ���� ������ ���� ����
				if (rocks[i] - prev < mid) {
					count++;
				} else { // mid���� ũ�ų� ���� ���� ���� ������ ����
					prev = rocks[i];
				}
			}

			// ������ ���� �������� ������ �Ÿ� Ȯ��
			// �Ÿ��� mid���� ������ ���� ����
			if (distance - prev < mid)
				count++;

			// �ּҰ� �߿� �ִ밪 ���ϱ� - ���� n���� ��
			// if(count == n){
			// answer = Math.max(answer, mid);

			if (count <= n) { // ���� n�� ������ �� <- �̰� ���� ó�� �Ǵ� �� ���� ���� ������ �ִ� ��!
				answer = Math.max(answer, mid); // mid > answer ? mid : answer;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}
}