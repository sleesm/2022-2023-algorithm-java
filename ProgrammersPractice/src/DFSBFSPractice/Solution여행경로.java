package DFSBFSPractice;

import java.util.*;

/**
 * tickets를 먼저 정렬하고 break;를 통해 계산하는 것보다
 * Collections.sort()를 사용하는 것이 훨씬 빠르고 정확하다!
 * @author water
 *
 */
class Solution여행경로 {
    
    boolean[] visited;
    ArrayList<String> routes;
    
    private void dfs(String start, String route, String[][] tickets, int count){
        if(count == tickets.length){
            routes.add(route);
        }
        
        for(int i = 0; i< tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + "," + tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {        
        visited = new boolean[tickets.length];
        routes = new ArrayList();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(routes);
        String[] answer = routes.get(0).split(",");
        
        return answer;
    }
}