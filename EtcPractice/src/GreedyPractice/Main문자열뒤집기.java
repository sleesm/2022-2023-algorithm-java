package GreedyPractice;

import java.util.Scanner;

class Main문자열뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int[] result = new int[2];
		int current = s.charAt(0) - '0';
		result[current]++;
		
		for(String tmp : s.split("")) {
			if(current != Integer.parseInt(tmp)) {
				current = Integer.parseInt(tmp);
				result[current]++;
			}
		}
		
		System.out.println(Math.min(result[0], result[1]));
	}

}
