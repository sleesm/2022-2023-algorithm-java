package GreedyPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			time[i][0] = sc.nextInt(); // 시작 시각
			time[i][1] = sc.nextInt(); // 끝 시각
		}
		sc.close();
		
		Arrays.sort(time,new Comparator<int[]>() {

			@Override
			public int compare(int[] t1, int[] t2) {
				
				if(t1[1] == t2[1])
					return t1[0] - t2[0];
				
				return t1[1] - t2[1];
			}
		});
		
		int count = 0;
		int previousTime = 0;
		for(int i = 0; i< n; i++)
			if(previousTime <= time[i][0]) {
				previousTime = time[i][1];
				count++;
			}
		
		System.out.print(count);
	}

}
