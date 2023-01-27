package SearchPractice;

import java.util.List;
import java.util.ArrayList;

class Solution모음사전2 {
    
    List<String> list = new ArrayList<>();
    
    void dfs(String s, int len){
        if(len > 5) return;
        list.add(s);
        for(int i = 0; i< 5; i++){
            dfs(s + "AEIOU".charAt(i), len+1);
        }
    }
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}