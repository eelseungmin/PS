import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            char tmp = stack.pop();
            
            if (stack.isEmpty()) {
                return 0;
            } else if (tmp == stack.peek()) {
                stack.pop();
            } else {
                return 0;
            }
        }
        
        return 1;
    }
}