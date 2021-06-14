//https://programmers.co.kr/learn/courses/30/lessons/1829
//[프로그래머스] level 2: 카카오프렌즈 컬러링북(bfs)

import java.util.Queue;
import java.util.LinkedList;
class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static boolean visited[][];
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited= new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0&&!visited[i][j]){
                    numberOfArea++;
                    bfs(i, j, m, n, picture);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int[] dx={-1, 0, 0, 1};
    static int[] dy={0, -1, 1, 0}; //상하좌우
    public void bfs(int x, int y, int m, int n, int[][] pic){
        int cnt=1, nx, ny;
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        visited[x][y]= true;
        while(!queue.isEmpty()){
            x= queue.poll();
            y= queue.poll();
            for(int i=0; i<4; i++){
                nx= x+dx[i];
                ny= y+dy[i];
                if(nx<0||nx>=m||ny<0||ny>=n) continue;
                if(!visited[nx][ny]&&pic[x][y]==pic[nx][ny]) {
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[nx][ny]= true;
                    cnt++;
                }
            }
        }
        maxSizeOfOneArea= maxSizeOfOneArea>cnt?maxSizeOfOneArea:cnt;
    }
}