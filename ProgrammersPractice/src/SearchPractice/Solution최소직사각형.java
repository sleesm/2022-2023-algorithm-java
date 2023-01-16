package SearchPractice;

class Solution최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxw = 1;
        int maxh = 1;
        for(int i = 0; i< sizes.length; i++){
            maxw = Math.max(maxw, Math.max(sizes[i][0], sizes[i][1]));
            maxh = Math.max(maxh, Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = maxw * maxh;
        return answer;
    }
}
