package HashPractice;

import java.util.Arrays;

class Solution전화번호목록 {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		String tmp = phone_book[0];
		boolean answer = true;
		for (int k = 1; k < phone_book.length; k++) {
			String t = "";
			String s = phone_book[k];
			boolean check = false;
			for (int i = 0; i < s.length(); i++) {
				t += s.charAt(i);
				if (tmp.equals(t)) {
					check = true;
					answer = false;
				}
			}
			if (!check) {
				tmp = s;
			}
		}
		return answer;
	}
}