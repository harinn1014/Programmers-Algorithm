//[Programmers] level2: 삼각 달팽이_Java
//https://programmers.co.kr/learn/courses/30/lessons/68645

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] mat= new int[n][n];
        
        int x=-1, y=0, idx=1;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){ //아래로
                    x++;
                }else if(i%3==1){//오른쪽으로
                    y++;
                }else{//대각선으로
                    x--;
                    y--;
                }
                mat[x][y]= idx++;
            }
        }
        
        idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) break;
                answer[idx++]= mat[i][j];
            }
        }
        
        return answer;
    }
}