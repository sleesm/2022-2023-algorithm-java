package GreedyPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		sc.close();
		
		if(n.charAt(0)== '0')
			return;
		
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(String s : n.split("")) {
			int i = Integer.parseInt(s);
			list.add(i);
			sum += i;
		}
		
		Collections.sort(list);
		if(list.contains(0) && sum%3 == 0) {
			for(int i = list.size()-1; i >= 0; i--) {
				System.out.print(list.get(i));
			}
		}
		else
			System.out.print(-1);
	}
}
