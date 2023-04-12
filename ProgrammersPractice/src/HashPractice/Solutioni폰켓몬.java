package HashPractice;

class SolutioniÆùÄÏ¸ó {
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] selected = new boolean[200001];
        for(int i : nums){
            if(answer == nums.length/2)
                break;
            if(!selected[i]){
                selected[i] = true;
                answer++;
            }
        }
        return answer;
    }
}