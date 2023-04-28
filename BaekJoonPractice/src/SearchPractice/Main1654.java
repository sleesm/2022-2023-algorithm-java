package SearchPractice;

import java.util.Scanner;

public class Main1654 {

	private static long binarySerach(int n, long max, int[] list) {
		long left = 0, right = max + 1;
		long mid = 0;
		while(left < right) {
			mid = (left + right)/2;
			long count = 0;
			for(int i = 0; i< list.length; i++) {
				count += (list[i]/mid);
			}
			if (count < n) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left-1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] list = new int[k];
		long max = 0;
		for(int i = 0; i< k; i++) {
			list[i] = sc.nextInt();
			max = Math.max(max, list[i]);
		}
		sc.close();
		
		System.out.println(binarySerach(n, max, list));
	}
}
