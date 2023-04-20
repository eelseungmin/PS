import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                stack.push(new Node(prices[i], i));
                continue;
            }
            
            if (stack.peek().price <= prices[i]) {
                stack.push(new Node(prices[i], i));
            } else {
                while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                    Node tmp = stack.pop();
                    ans[tmp.idx] = i - tmp.idx;
                }
                stack.push(new Node(prices[i], i));
            }
        }
        
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            ans[tmp.idx] = prices.length - 1 - tmp.idx;
        }
        
        return ans;
    }
    
    class Node {
        int price, idx;
        
        Node (int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }
}