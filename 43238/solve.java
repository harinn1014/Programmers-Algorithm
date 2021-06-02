//https://programmers.co.kr/learn/courses/30/lessons/43238
//문제: 입국심사, 이분탐색
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long min= 0;
        long max= (long)times[times.length-1]*n;
        long mid=0, sum;
        answer=max;
        
        while(min<=max){
            sum=0;
            mid= (min+max)/2;
            for(int i: times){
                sum+=mid/i;
            }
            if(sum>=n){
                if(mid<answer){
                    answer=mid;
                }
                max=mid-1;
            }else{ //sum<n
                min=mid+1;
            }
        }
        
        return answer;
    }
}