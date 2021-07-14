//[Programmers] level 2: 카펫_Java
//완전 탐색, 쉬운 문제(오히려 이해가 어려움;)

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x=0, y=0; //x가로, y세로
        int bsum;
        
        for(int i=1; i<=Math.sqrt(yellow); i++){
            bsum=0;
            if(yellow%i==0){
                bsum+=2*i+2*(yellow/i)+4;
                if(bsum==brown){
                    answer[0]=yellow/i+2;
                    answer[1]=i+2;
                    break;
                }
            }
        }
        
        return answer;
    }
}