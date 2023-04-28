import java.util.*;

class Solution {
    static String[][] rel;
    static boolean[] isUsed;
    static ArrayList<String> answer;
    
    public int solution(String[][] relation) {
        rel = relation;
        answer = new ArrayList<>();
        // 컬럼이 1개인 조합, 컬럼이 2개인 조합...
        for (int i = 1; i <= rel[0].length; i++) {
            isUsed = new boolean[rel[0].length];
            comb(0, 0, i);
        }
        
        return answer.size();
    }
    
    void comb(int idx, int cnt, int max) {
        if (cnt == max) { // 조합 완성
            int[] comb = new int[max];
            int j = 0;
            for (int i = 0; i < isUsed.length; i++) {
                if (isUsed[i]) {
                    comb[j] = i;
                    j++;
                }
            }
            
            check(comb); // 유일성, 최소성 검사
            
            return;
        }
        
        for (int i = idx; i < isUsed.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                comb(idx + 1, cnt + 1, max);
                isUsed[i] = false;
            }
        }
    }
    
    void check(int[] target) {
        // 유일성 검사
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rel.length; i++) {
            String cur = "";
            for (int j = 0; j < target.length; j++) {
                cur += rel[i][target[j]];
            }
            // for문이 끝나면 cur은 "100ryanmusic2" 같은 형태
            if (!set.contains(cur)) {
                set.add(cur);
            } else {
                return; // 중복되는 순간 유일성 x
            }
        }
        
        String comb = "";
        for (int t : target) {
            comb += t;
        }
    
        // 최소성 검사
        for (String a : answer) {
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (comb.contains(a.charAt(i) + "")) {
                    cnt++;
                }
            }
            if (cnt == a.length()) { // 최소성 x
                return;
            }
        }
        
        answer.add(comb);
        return;
    }
}