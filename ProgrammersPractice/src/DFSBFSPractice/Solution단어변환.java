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

class Solution�ܾȯ {
    
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
        
        //��ȯ�� �� ���� ��� - ���� ó���� ���� �߰�.
        boolean check = false;
        for(String s : words){
            if(s.equals(target))
                check = true;
        }
        if(!check)
            return 0;
        
        //��ȯ�� �� �ִ� ��� (��ȯ�� �� ���� ��쵵 ����)
        Arrays.sort(words);
        answer = bfs(begin, 0, target, words);
        
        return answer;
    }
}