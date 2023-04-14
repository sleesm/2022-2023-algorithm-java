package SearchPractice;

import java.util.*;

/**
 * �̺�(����) Ž�� 
 */
class Solution�Ա��ɻ� {
	public long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times); // �־��� ��츦 ã�� ���� ����
		long start = 1; // �ּ��� ���
		long end = (long) times[times.length - 1] * n; // �־��� ���

		while (start <= end) {
			long sum = 0;
			long mid = (start + end) / 2;

			// �ɻ������ �߰� �ð��� �������� �ɻ��� �� �ִ� ����� ���� ��
			// ������ �Ǵ� ���� ������
			for (int time : times) {
				sum += mid / time;
			}

			if (sum >= n) { // �ɻ���� ������� ���ų� ���� ���
				end = mid - 1;
				answer = mid;
			} else { // �ɻ� ���� ������� ���� ���
				start = mid + 1;
			}
		}

		return answer;
	}
}