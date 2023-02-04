package DFSBFSPractice;

import java.util.HashMap;

/***
 * 2021 Dev-Matching: �� �鿣�� ������(��ݱ�)
 * Arrays�� indexOf()�� ����ϴ� �ͺ��� HashMap�� get()�� ����ϴ� ���� �ӵ��� �� ������!
 * �� ������ �׽�Ʈ���̽����� �ð��ʰ� ������ ������!!
 */
class Solution�ٴܰ�ĩ���Ǹ� {
	HashMap<String, Integer> list = new HashMap<String, Integer>();
	int[] answer;
	String[] referral;

	void dfs(double price, String name) {
		int index = list.get(name);
		int onePer = (int) (price * 0.1);
		if (onePer < 1) {
			answer[index] += price;
			return;
		}
		answer[index] += price - onePer;
		if (referral[index].equals("-"))
			return;
		dfs(price * 0.1, referral[index]);

	}

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		answer = new int[enroll.length];
		this.referral = referral;
		for (int i = 0; i < enroll.length; i++) {
			list.put(enroll[i], i);
		}

		for (int i = 0; i < seller.length; i++) {
			dfs(amount[i] * 100, seller[i]);
		}

		return answer;
	}
}