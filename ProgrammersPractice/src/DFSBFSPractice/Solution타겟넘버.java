package DFSBFSPractice;

class SolutionÅ¸°Ù³Ñ¹ö {
    
    int[] list;
    int count = 0; 
    
    private void dfs(int sum, int target, int index){
        if(index >= list.length){
            if(sum == target){
                count++;
            }
            return;
        }
        dfs(sum + list[index] , target, index + 1);
        dfs(sum - list[index] , target, index + 1);
    }
    
    public int solution(int[] numbers, int target) {
        list = numbers;
        
        dfs(0, target, 0);
        
        return count;
    }
}