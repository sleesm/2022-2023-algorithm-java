package DPPractice;

import java.util.*;
class SolutionN으로표현 {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> countList = new ArrayList();
        for(int i = 0; i< 9; i++){
            countList.add(new HashSet());
        }
        
        countList.get(1).add(N);
        
        for(int i = 2; i< 9; i++){
            
            for(int j = 1; j<=i; j++){
                Set<Integer> preList = countList.get(j);
                Set<Integer> postList = countList.get(i-j);
                
                for(int pre : preList){
                    for(int post : postList){
                        countList.get(i).add(pre + post);
                        countList.get(i).add(pre - post);
                        countList.get(i).add(pre * post);
                        
                        if(pre != 0 && post != 0)
                            countList.get(i).add(pre / post);
                    }
                }
            }
            
            countList.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        
        for(Set<Integer> tmp : countList){
            if(tmp.contains(number))
                return countList.indexOf(tmp);
        }
        
        return -1;
    }
}