package SortPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Member{
	public String name;
	public int grade;
	
	Member(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
}
class Main성적이낮은순서대로학생출력하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Member[] list = new Member[n];
		
		for(int i = 0; i< n; i++) {
			String s = sc.nextLine();
			String[] tmp = s.split(" ");
			list[i] = new Member(tmp[0], Integer.parseInt(tmp[1]));
		}
		sc.close();
		
		Arrays.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.grade - m2.grade;
            }
        });
		
		for(int i = 0; i< n; i++) {
			System.out.print(list[i].name +" ");
		}
	}

}
