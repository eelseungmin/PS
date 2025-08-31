import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        int max = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) {
                score[0]++;
            }
            if (two[i % two.length] == answers[i]) {
                score[1]++;
            }
            if (three[i % three.length] == answers[i]) {
                score[2]++;
            }
            max = Math.max(Math.max(score[0], score[1]), score[2]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == score[i]) {
                list.add(i + 1);
            }
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}