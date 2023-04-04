import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder ans = new StringBuilder(s);
        int diff = 'A' - 'a';
        for (int i = 0; i < ans.length(); i++) {
            char tmp = ans.charAt(i);
            
            if (Character.isUpperCase(tmp)) {
                if (i != 0 && ans.charAt(i - 1) != ' ') {
                    ans.setCharAt(i, (char) (tmp - diff));
                }
            } else if (Character.isLowerCase(tmp)) {
                if (i == 0 || (i != 0 && ans.charAt(i - 1) == ' ')) {
                    ans.setCharAt(i, (char) (tmp + diff));
                }
            }
        }
        
        return ans.toString();
    }
}