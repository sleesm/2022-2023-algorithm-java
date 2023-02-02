package ImplementationPractice;

/**
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 */
class Solution행렬테두리회전하기 {
    int[][] map;
    
    int changeMap(int rows, int cols, int x1, int y1, int x2, int y2){
        int[][] tmp = new int[rows][cols];
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                tmp[i][j] = map[i][j];
            }
        }
        
        int num = map[x1-1][y1-1];
        //위
        for(int i = y1 + 1; i <= y2; i++){
            tmp[x1-1][i-1] = map[x1-1][i-2];
            num = Math.min(num, tmp[x1-1][i-1]);
        }
        //오른쪽
        for(int i = x1 + 1; i <= x2; i++){
            tmp[i-1][y2-1] = map[i-1-1][y2-1];
            num = Math.min(num, tmp[i-1][y2-1]);
        }
        //아래
        for(int i = y2 - 1; i >= y1; i--){
            tmp[x2-1][i-1] = map[x2-1][i];
            num = Math.min(num, tmp[x2-1][i-1]);
        }
        //왼쪽
        for(int i = x2 -1; i >= x1; i--){
            tmp[i-1][y1-1] = map[i][y1-1];
            num = Math.min(num, tmp[i-1][y1-1]);
        }
        
        map = tmp;
        return num;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                map[i][j] = i*columns + j + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
             answer[i] = changeMap(rows, columns, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        
        return answer;
    }
}