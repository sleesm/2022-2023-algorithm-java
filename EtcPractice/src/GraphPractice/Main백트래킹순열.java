package GraphPractice;

class Main백트래킹순열 {

	// 사전순으로 순열 구하기
	static public void backtracking(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// 종료 조건이자 순열 출력 부분
		if (depth == r) {
			print(output, r);
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (visited[i] == false) {
					visited[i] = true; // 방문 체크
					output[depth] = arr[i]; // depth가 output의 인덱스 역할을한다. - 숫자의 위치 변화
					backtracking(arr, output, visited, depth + 1, n, r);
					visited[i] = false;// 원상복귀 중요!
				}
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

		// 중복 x -> 방문 체크
		boolean[] visited = new boolean[n];

		// 입력 배열, 뽑아낼 원소들 배열, 방문 배열, depth, n, r)
		backtracking(arr, output, visited, 0, n, r);

	}

}
