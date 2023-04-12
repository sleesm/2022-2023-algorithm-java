package HashPractice;

import java.util.*;

class Solution완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);

		boolean check = false;
		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				check = true;
				break;
			}
		}

		if (!check)
			answer = participant[participant.length - 1];

		return answer;
	}
}