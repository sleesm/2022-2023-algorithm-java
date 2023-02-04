package DFSBFSPractice;

import java.util.HashMap;

/***
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * Arrays의 indexOf()를 사용하는 것보다 HashMap의 get()을 사용하는 것이 속도가 더 빠르다!
 * 위 문제로 테스트케이스에서 시간초과 문제가 떴었음!!
 */
class Solution다단계칫솔판매 {
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