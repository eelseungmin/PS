import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        TreeSet<Integer> bst = new TreeSet<>();
        while (st.hasMoreTokens()) {
            bst.add(Integer.parseInt(st.nextToken()));
        }
        
        return bst.first() + " " + bst.last();
    }
}