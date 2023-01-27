package SearchPractice;

import java.util.*;

class Solution전력망을둘로나누기 {
    ArrayList<Integer>[] list;
    
    int bfs(int v1, int v2, int n){
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] visited = new boolean[n+1];
        visited[v1] = true;
        q.offer(v1);
        int count = 0;
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            count++;
            for(int i : list[tmp]){
                if(i!= v2 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return (int) Math.abs(n-count*2);
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        list = new ArrayList[n+1];
        for(int i = 1;i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i = 0; i< wires.length; i++){
            answer = Math.min(answer, bfs(wires[i][0], wires[i][1], n));
        }
        
        return answer;
    }
}