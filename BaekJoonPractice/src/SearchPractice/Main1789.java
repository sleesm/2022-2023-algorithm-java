package SearchPractice;

import java.util.Scanner;

class Main1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		sc.close();
		
		long i = 1;
		long sum = 0; 
		long answer = 0;
		while(true) {
			sum += i++;
			answer++;
			if(sum > s)
				break;
		}
		System.out.println(answer-1);
	}
}
