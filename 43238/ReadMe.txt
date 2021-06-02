[Programmers] level 2: 입국심사_Java
https://programmers.co.kr/learn/courses/30/lessons/43238

n이 10억까지 들어올 수 있기 때문에 범위에 주의해야합니다.

간단하게 n이 10억이고 심사관은 1명 이며 3초씩 걸릴 경우, 30억의 시간이 걸립니다.

int의 범위는 -2,147,483,648 ~ 2,147,483,647 라서 범위 초과가 발생합니다.

​

이제 min=0;  max= (long)times[times.length-1]*n; sum=0; min=0; 선언

mid 시간 안에 심사관들이 심사할 수 있는 인원수(sum)을 n과 비교하여 min 또는 max값을 조정해가며 이분탐색을 해줍니다.