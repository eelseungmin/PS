class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = {};
        int area = brown + yellow;
        for (int i = 1; i <= area; i++) {
            int row = i; // 세로
            if (area % row != 0) {
                continue;
            }
            int col = area / row; // 가로
            
            if (col >= row && (col - 2) * (row - 2) == yellow) {
                ans = new int[]{col, row};
                break;
            }
        }
        
        return ans;
    }
}