package GraphPractice;

import java.util.ArrayList;

class Main부분집합 {

	static void subset(int[] arr, boolean[] selected, int depth) {
		if(depth == arr.length) {
			print(arr, selected);
			return;
		}
		selected[depth] = true;
		subset(arr, selected, depth + 1);
		selected[depth] = false;
		subset(arr, selected, depth + 1);
	}
	
	static void subsuetUsingIntArray(int[] arr, int[] selected, int depth, int sIdx) {
		if(depth == arr.length) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i< sIdx; i++) {
				list.add(selected[i]);
			}
			System.out.print(list);
			return;
		}
		
		subsuetUsingIntArray(arr, selected, depth + 1, sIdx);
		selected[sIdx] = arr[depth];
		subsuetUsingIntArray(arr, selected, depth + 1, sIdx + 1);
	}
	
	static void print(int[] arr, boolean[] selected) {
		for (int i = 0; i < selected.length; i++)
			if(selected[i])
				System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// 사용할 n개의 수 
		int[] arr = { 1, 2, 3 };

		boolean[] selected = new boolean[ arr.length];
		int[] select = new int[arr.length];

		// 입력 배열, 선택 유무를 저장하는 배열, depth
		subset(arr, selected,  0);
		
		// 입력 배열, 부분 집합 저장하는 배열, depth, select의 인덱스 값
		subsuetUsingIntArray(arr, select, 0, 0);
	}

}
