//https://programmers.co.kr/learn/courses/30/lessons/42895
//[프로그래머스]level 3: N으로 표현(dp)_Java


import java.util.HashSet;
import java.util.List;
import java.util.Iterator;
class Solution {
    static HashSet<Integer> dp[]= new HashSet[9];
    public int solution(int N, int number) {
        int answer = 0;
        
        if(number==N){
            return 1;
        }
        
        String strN= String.valueOf(N);  //예를 들어 N=5이면 strN="5"
        for(int i=1; i<9; i++){
            dp[i]= new HashSet<Integer>();
            if(i==1){
                dp[i].add(Integer.parseInt(strN));
                continue;
            }
            //2부터는
            strN+=String.valueOf(N); //i값에 따라 "55", "555"등 자릿수를 늘려가기 위해
            dp[i].add(Integer.parseInt(strN));
            for(int j=1; j<i; j++){
                calc(j, i);
                if(dp[i].contains(number)) return i;  //찾고있는 number가 나오면 return
            }
        }
        
        return -1;
    }
    
    public void calc(int x, int y){ //사칙 연산
        int numx, numy;
        Iterator<Integer> list_x= dp[x].iterator(); //dp[x]값을 전부 가져온다.
        Iterator<Integer> list_y= dp[y-x].iterator(); //dp[y-x]값을 전부 가져온다.
        
        while(list_x.hasNext()){
            numx= list_x.next();
            while(list_y.hasNext()){
                numy= list_y.next();
                dp[y].add(numx+numy);
                dp[y].add(numx-numy);
                dp[y].add(numx*numy);
                if(numy!=0) dp[y].add(numx/numy); //주의) 0으로 나누면 안됨
            }
            list_y=dp[y-x].iterator();
        }
        
    }
}