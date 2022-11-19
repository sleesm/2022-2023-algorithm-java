package ImplementationPractice;

import java.util.Scanner;

/**
 * �׸��� 
 * �ս��� ����Ʈ
 */
class Main�ս��ǳ���Ʈ {

	private static boolean check(int x, int y) {
		if(x< 1 || y < 1 || x > 8 || y> 8)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		
		int x = s.charAt(0) - 'a' + 1;
		int y = s.charAt(1) - '0';
		
		int[][] go = {{1,2}, {2,1}, {-1,-2}, {-2,-1}, {-1,2}, {-2,1}, {1,-2}, {2,-1}};
		
		int count = 0;
		for(int i = 0; i< 8; i++) {
			int dx = x + go[i][0];
			int dy = y + go[i][1];
			if(check(dx,dy))
				count++;
		}
		System.out.println(count);
	}
}
