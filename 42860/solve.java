//https://programmers.co.kr/learn/courses/30/lessons/42860
//[Programmers] level 2: 조이스틱
//Greedy(탐욕 알고리즘)

import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char d;
        
        for(int i=0; i<name.length(); i++){
            d= name.charAt(i);
            answer+=Math.min(d-'A', Math.abs('A'+26-d));
        }
        
        int minlen= name.length()-1;
        int end, cnt;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)=='A') continue;
            end= i+1;
            while(end<name.length()&&name.charAt(end)=='A'){
                end++;
            }
            cnt=i*2+(name.length()-end);
            minlen= Math.min(minlen, cnt);
        }
        
        return answer+minlen;
    }
}
