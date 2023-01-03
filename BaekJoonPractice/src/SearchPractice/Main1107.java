package SearchPractice;

import java.util.Scanner;

class Main1107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean [] broken = new boolean[10];
		for(int i = 0; i< m; i++) {
			broken[sc.nextInt()] = true;
		}
		sc.close();
		
		int result = Math.abs(n - 100);
		for(int i = 0; i< 999999; i++) {
			String s = String.valueOf(i);
			boolean check = false;
			for(int j = 0; j< s.length(); j++) {
				if(broken[s.charAt(j) - '0']) {
					check = true;
					break;
				}
			}
			
			if(!check) {
				int tmp = Math.abs(n - i) + s.length();
				result = Math.min(tmp, result);
			}
		}
		
		System.out.print(result);
	}
}
