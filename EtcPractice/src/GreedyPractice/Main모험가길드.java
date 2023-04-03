package GreedyPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main¸ðÇè°¡±æµå {

	private static int[] checkCount(int[] list, int index) {
		int count = list[index];
		int result = 1;
		int check = 0; //0: µÊ, 1: ¾È µÊ
		for (int i = index; (i < index + count) && (i < list.length) ; i++) {
			if (count < list[i])
				count = Math.max(count,  list[i]);
			if(result == count) {
				check = 0;
				break;
			}
			else
				check = 1;
			
			result++;
			
		}
		return new int[] {check, result};
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();

		Arrays.parallelSort(list);

		int result = 0;
		for (int i = 0; i < n;) {
			int[] tmp = checkCount(list, i);
			if(tmp[0] == 0)
				result++;
			i += tmp[1];
		}
		System.out.println("´ä : " + result);
	}

}
