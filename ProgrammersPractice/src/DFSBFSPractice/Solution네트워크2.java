package DFSBFSPractice;

import java.util.*;
class Solution네트워크2 {
    boolean[] visited;
    int answer;
    
    private void bfs(int index, int[][] computers){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(index);
        visited[index] = true;
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 0; i< computers.length; i++){
                if(!visited[i] && computers[tmp][i] == 1){
                    answer--;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = n;
        
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i])
                bfs(i, computers);
        }
        
        return answer;
    }
}