class Solution {
    static int N, ans;
    static int[] row;
    
    public int solution(int n) {
        N = n;
        ans = 0;
        row = new int[N + 1];
        
        recursion(1);
        
        return ans;
    }
    
    void recursion(int k) {
        if (k == N + 1) {
            ans++;
            return;
        }
        
        for (int col = 1; col <= N; col++) {
            boolean canAttack = false;
            for (int j = 1; j < k; j++) {
                if (check(k, col, j, row[j])) {
                    canAttack = true;
                    break;
                }
            }
            
            if (!canAttack) {
                row[k] = col;
                recursion(k + 1);
                row[k] = 0;
            }
        }
    }
    
    /*
     1 2 3
    12 3 4
    23 4 
    34
    */
    boolean check(int r1, int c1, int r2, int c2) {
        if (c1 == c2 || r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2) {
            return true;
        }
        return false;
    }
}