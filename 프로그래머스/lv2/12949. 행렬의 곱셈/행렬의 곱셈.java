class Solution {
    /*
    00 01
    10 11
    20 21
    
    00 01
    10 11
    
    00*00+01*10 00*01+01*11 00 01
    10*00+11*10 10*01+11*11 10 11
    20*00+21*10 20*01+21*11 20 21
    */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    ans[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return ans;
    }
}