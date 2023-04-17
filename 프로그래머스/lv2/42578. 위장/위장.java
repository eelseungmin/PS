import java.util.*;

class Solution {
    /*
    hat
    crow hat
    blue hat
    smoky hat
    crow
    blue
    smoky
    */
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int ans = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (ans == 0) {
                ans += entry.getValue() + 1;
            } else {
                ans *= entry.getValue() + 1;
            }
        }
        
        return ans - 1;
    }
}