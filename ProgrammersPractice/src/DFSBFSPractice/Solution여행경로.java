package DFSBFSPractice;

import java.util.*;

/**
 * tickets�� ���� �����ϰ� break;�� ���� ����ϴ� �ͺ���
 * Collections.sort()�� ����ϴ� ���� �ξ� ������ ��Ȯ�ϴ�!
 * @author water
 *
 */
class Solution������ {
    
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