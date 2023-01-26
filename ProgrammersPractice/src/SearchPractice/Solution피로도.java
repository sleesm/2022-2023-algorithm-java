package SearchPractice;

class Solution««∑Œµµ {
    
    boolean[] visited;
    int answer;
    
    void searchDungeons(int[][] dungeons, int k, int count){
         for(int i = 0; i< dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                searchDungeons(dungeons, k - dungeons[i][1] , count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        
        searchDungeons(dungeons, k, 0);
        
        return answer;
    }
}