import java.util.*;

class Solution {
    /*
    n-1개의 원판을 기둥 2로 옮긴다.
    원판 n을 기둥 3으로 옮긴다.
    n-1개의 원판을 기둥 3으로 옮긴다.
    */
    static ArrayList<int[]> cases;
    
    public int[][] solution(int n) {
        cases = new ArrayList<>();
        
        hanoi(1, 3, n);
        
        int[][] ans = new int[cases.size()][2];
        for (int i = 0; i < cases.size(); i++) {
            ans[i][0] = cases.get(i)[0];
            ans[i][1] = cases.get(i)[1];
        }
        
        return ans;
    }
    
    void hanoi(int a, int b, int n) { // n개의 원판을 기둥 a에서 b로 옮기기
        if (n == 1) {
            cases.add(new int[]{a, b});
            return;
        }
        
        hanoi(a, 6 - a - b, n - 1);
        cases.add(new int[]{a, b});
        hanoi(6 - a - b, b, n - 1);
    }
}