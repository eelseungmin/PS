import java.util.*;

/*
몸무게가 큰 사람 + 작은 사람
*/
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0; // 정답
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] > limit) {
                answer++; // r 혼자 타기
                r--;
            } else {
                answer++; // l과 r 같이 타기
                l++;
                r--;
            }
        }
        
        return answer;
    }
}