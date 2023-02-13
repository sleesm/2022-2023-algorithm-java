package DFSBFSPractice;
import java.util.*;
class Solution네트워크1 {
    ArrayList<Integer>[] list;
    boolean[] visited;
    int answer;
    
    private void bfs(int index){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(index);
        visited[index] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i: list[tmp]){
                if(!visited[i]){
                    answer--;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = n;
        list = new ArrayList[n];
         for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j< n; j++){
                if(computers[i][j] == 1 && i!=j)
                    list[i].add(j);
            }
        }
        
        visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i])
                bfs(i);
        }
        
        return answer;
    }
}