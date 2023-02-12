package DFSBFSPractice;

import java.util.*;
class Solution게임맵최단거리 {
    
    int[][] map;
    int n, m;
    int[][] dxy = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean[][] visited;
    
    private void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i = 0; i< 4; i++){
                int nx = current[0] + dxy[i][0];
                int ny = current[1] + dxy[i][1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny>= m)
                    continue;
                if(map[nx][ny] == 0 || visited[nx][ny])
                    continue;
                    
                visited[nx][ny] = true;
                map[nx][ny] += map[current[0]][current[1]];
                
                q.offer(new int[]{nx, ny});
            }            
        }

    }
    
    public int solution(int[][] maps) {
        map = maps;
        n = map.length;
        m = map[0].length;
        visited = new boolean[n][m];
        
        bfs(0,0);
        
        if(!visited[n-1][m-1])
            return -1;
        
        return map[n-1][m-1];
    }
}