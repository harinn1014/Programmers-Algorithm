//[Programmers] level 2: 튜플_Java
//https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;
class Solution {
    public int[] solution(String s) {
        int idx=0;
        int[] answer = {};
        LinkedList<Integer> list= new LinkedList<>();
        
        String[] arr= s.split("\\{|\\},\\{|\\}");
        
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("")) continue;
            String[] tuple= arr[i].split(",");
            for(int j=0; j<tuple.length; j++){
                if(!list.contains(Integer.parseInt(tuple[j])))
                    list.add(Integer.parseInt(tuple[j]));
            }
        }
        
        answer= new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]= list.get(i);
        }
        
        return answer;
    }
}