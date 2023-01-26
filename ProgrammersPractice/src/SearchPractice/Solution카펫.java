package SearchPractice;

class SolutionÄ«Æê {
    
    private boolean check(int x, int y, int b){
        if(x > y) return false;
        if(2*x + (y-2) * 2 == b)
            return true;
        return false;
    }
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i = 1; i*i <= sum; i++){
            if(sum % i == 0){
                if(check(i, sum/i, brown)){
                    answer[0] = sum/i;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}