package SearchPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ¿Ã∫– ≈Ωªˆ
 * ∂±∫∫¿Ã ∂± ∏∏µÈ±‚
 */
class Main∂±∫∫¿Ã∂±∏∏µÈ±‚ {

	private static int cal(int[] list, int midValue) {
		int sum = 0;
		for (int i : list) {
			if (i > midValue)
				sum += (i - midValue);
		}
		return sum;
	}

	private static int binarySearch(int[] list, int x) {
		int first = 0; // ∞°¿Â ¬™¿∫ ±Ê¿Ã∞° æ∆¥— 0∫Œ≈Õ Ω√¿€!!
		int last = Arrays.stream(list).max().getAsInt(); // ∞°¿Â ±‰ ±Ê¿Ã
		int mid;

		int result = 0;
		while (first <= last) {  
			mid = (first + last) / 2;
			if (x> cal(list, mid))
				last = mid - 1;
			else {
				first = mid + 1;
				result = mid; //Math.max(mid, result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		sc.close();

		System.out.print(binarySearch(list, m));
	}
}
