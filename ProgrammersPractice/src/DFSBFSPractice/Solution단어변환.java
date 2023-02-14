package DFSBFSPractice;

import java.util.*;

class StringInteger {
    String word;
    int answer;
    
    StringInteger(String word, int answer){
        this.word = word;
        this.answer= answer;
    }
}

class Solution단어변환 {
    
    private int bfs(String begin, int index, String target, String[] words){
        Queue<StringInteger> q = new LinkedList();
        int answer = 0;
        q.offer(new StringInteger(begin, answer));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            StringInteger tmp = q.poll();
            if(tmp.word.equals(target)){
               return tmp.answer;
            } 
            for(int j= 0; j< words.length; j++){
                if(visited[j])
                    continue;
                
                int count = 0;
                for(int i = 0; i< target.length(); i++){
                    if(tmp.word.charAt(i) != words[j].charAt(i)){
                        count++;
                    }
                }
                
                if(count == 1){
                    visited[j] = true;
                    q.offer(new StringInteger(words[j], tmp.answer + 1));
                }
            }
        }
        return answer; 
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //변환할 수 없는 경우 - 빠른 처리를 위해 추가.
        boolean check = false;
        for(String s : words){
            if(s.equals(target))
                check = true;
        }
        if(!check)
            return 0;
        
        //변환할 수 있는 경우 (변환할 수 없는 경우도 포함)
        Arrays.sort(words);
        answer = bfs(begin, 0, target, words);
        
        return answer;
    }
}