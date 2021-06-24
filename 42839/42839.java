//프로그래머스 level2: 소수찾기
//완전탐색, 에라토스테네스의 체

import java.util.HashSet;
class Solution {
    static HashSet<Integer> set= new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        arr= new char[numbers.length()];
        visited= new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i]=numbers.charAt(i);
        }
        recursion("", 0);
        
        answer= set.size();
        return answer;
    }
    
    //재귀: 가능한 숫자 조합을 찾고 소수여부에 따라 set에 추가
    public void recursion(String str, int idx){
        int num;
        if(str!="") {
            num= Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        
        if(idx== arr.length) return;
        
        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i]= true;
            recursion(str+arr[i], idx+1);
            visited[i]= false;
        }
    }//rec
    
    public boolean isPrime(int num){ //소수 판별
        if(num==1||num==0) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}