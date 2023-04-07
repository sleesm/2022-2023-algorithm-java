package GraphPractice;

class Main조합 {

	// 조합 구하기
	static public void combination(int[] arr, int[] output, int start, int depth, int n, int r) {
		// 종료 조건이자 조합 출력 부분
		if (depth == r) {
			print(output, r);
			return;
		} else {
			for (int i = start; i < n; i++) {
				output[depth] = arr[i];
				combination(arr, output, i + 1, depth + 1, n, r); // start는 현재 i 값을 기준으로  +1 되는 것 !!!
			}
		}
	}

	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// 사용할 n개의 수 중에서
		int[] arr = { 1, 2, 3 };
		int n = arr.length;

		// r개 뽑을 것
		int r = 3;
		int[] output = new int[r];

		// 입력 배열, 뽑아낼 원소들 배열, start, depth, n, r)
		combination(arr, output, 0, 0, n, r);

	}

}
