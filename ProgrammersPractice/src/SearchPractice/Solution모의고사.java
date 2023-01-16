package SearchPractice;

import java.util.List;
import java.util.ArrayList;

class Solution모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] t = new int[3];
        for(int i = 0; i< answers.length; i++){
            if(answers[i] == one[i%5])
                t[0]++;
            if(answers[i] == two[i%8])
                t[1]++;
            if(answers[i] == three[i%10])
                t[2]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int tmp = Math.max(t[0], Math.max(t[1], t[2]));
        for(int i = 0; i< 3; i++){
            if(tmp == t[i]){
                
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
