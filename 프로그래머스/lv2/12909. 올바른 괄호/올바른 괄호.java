import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}