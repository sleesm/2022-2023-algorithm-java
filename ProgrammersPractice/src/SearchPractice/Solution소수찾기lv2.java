package SearchPractice;

import java.util.HashSet;

class Solution소수찾기lv2 {
    
    HashSet<Integer> primeList = new HashSet<Integer>();
    boolean[] visited;
    
    private boolean checkPrime(int n){
        if(n==0 | n==1) return false;
        for(int i = 2; i*i<= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    private void dfsNums(String s, int index, char[] list){
        if(s != ""){
            int tmp = Integer.parseInt(s);
            if(checkPrime(tmp))
                primeList.add(tmp);
        }
        if(index == list.length) return;
        
        for(int i = 0; i< list.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfsNums(s + list[i] , index+ 1, list);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        char[] list = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i = 0; i< numbers.length(); i++){
            list[i] = numbers.charAt(i);
        }
        
        dfsNums("", 0, list);
        
        answer = primeList.size();
        
        return answer;
    }
}