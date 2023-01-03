package SearchPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 이진 탐색
 * 부품 찾기
 */
class Main부품찾기 {

	private static boolean binarySearch(int[] list, int x) {
		int first = 0;
		int last = list.length - 1;
		int mid;

		while (first <= last) {
			mid = (first + last) / 2;
			if (list[mid] < x)
				first = mid + 1;
			else if (list[mid] > x)
				last = mid - 1;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nlist = new int[n];

		for (int i = 0; i < n; i++) {
			nlist[i] = sc.nextInt();
		}
		Arrays.sort(nlist);

		int m = sc.nextInt();
		boolean[] mlist = new boolean[m];

		for (int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			mlist[i] = binarySearch(nlist, tmp);
		}
		sc.close();

		for (int i = 0; i < m; i++) {
			if(mlist[i])
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
	}
}
