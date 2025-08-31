import java.util.*;

/**
길이 결정
조합 생성
소수 여부 체크
**/

class Solution {
    static int ans = 0;
    static String input;
    static boolean[] vis;
    static Set<Integer> set = new HashSet<>(); 
    
    public int solution(String numbers) {
        input = numbers;
        vis = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++) {
            choose(0, i, "");
        }
        
        return set.size();
    }
    
    public void choose(int idx, int max, String result) {
        if (idx == max) {
            if (isPrime(Integer.parseInt(result))) {
                set.add(Integer.parseInt(result));
            }
            return;
        }
        
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                choose(idx + 1, max, result + input.charAt(i));
                vis[i] = false;
            }
        }
    }
    
    public boolean isPrime(int target) {
        if (target == 0 || target == 1) {
            return false;
        }
        for (int i = 2; i * i <= target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}