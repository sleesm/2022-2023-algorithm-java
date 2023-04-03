package GreedyPractice;

import java.util.Scanner;

class Main곱하기혹은더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int result = 0;
		for (String tmp : s.split("")) {
			int i = Integer.parseInt(tmp);
			if (i <= 1)
				result += i;
			else {
				if(result == 0)
					result = 1;
				result *= i;
			}
		}
		System.out.println(result);
	}

}
