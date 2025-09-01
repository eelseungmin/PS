import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 사전순 내림차순 정렬
        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numStr, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        if (numStr[0].equals("0")) {
            return "0";
        }
        
        String ans = "";
        for (String num : numStr) {
            ans += num;
        }
        
        return ans;
    }
}