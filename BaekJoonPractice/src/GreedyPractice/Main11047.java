package GreedyPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int k = sc.nextInt();
		for(int i = 0; i< n; i++) {
			list.add(sc.nextInt());
		}
		sc.close();
		Collections.sort(list, Collections.reverseOrder());
		
		int count = 0;
		for(int i : list) {
			if(k >= i) {
				count += k/i;
				k = k%i;
			}
		}
		System.out.println(count);
	}
}