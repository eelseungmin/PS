import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] cnt = new int[n + 1]; // 1~n번 사람의 현재 차례 기록
        HashSet<String> set = new HashSet<>(); // 단어 중복 체크
        
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                cnt[i % n + 1]++;
                set.add(words[i]);
                continue;
            }
            
            cnt[i % n + 1]++;
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || set.contains(words[i])) {
                return new int[]{i % n + 1, cnt[i % n + 1]};
            }
            set.add(words[i]);
        }
        
        return new int[]{0, 0};
    }
}