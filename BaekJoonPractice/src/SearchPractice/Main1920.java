package SearchPractice;

import java.util.Arrays;
import java.util.Scanner;

class Main1920 {

	private static boolean binarySearch(int m, int[] narray) {
		int left = 0;
		int right = narray.length - 1;
		int mid;
		while(left <= right) {
			mid = (left + right)/2;
			if(narray[mid] == m) {
				return true;
			}else if(narray[mid] > m) {
				right = mid -1;
			}else {
				left = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] narray = new int[n];
		for(int i = 0; i< n; i++) {
			narray[i] = sc.nextInt();
		}
		Arrays.sort(narray);
		
		int m = sc.nextInt();
		for(int i = 0; i< m; i++) {
			if(binarySearch(sc.nextInt(), narray))
				System.out.println("1");
			else
				System.out.println("0");
		}
		sc.close();
	}

}
