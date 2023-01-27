package SearchPractice;

class Solution모음사전1 {
    public int solution(String word) {
        int answer = 0;
        int value = 3905;
        for(String tmp : word.split("")){
            answer += "AEIOU".indexOf(tmp) * (value/=5) + 1;
        }
        return answer;
    }
}