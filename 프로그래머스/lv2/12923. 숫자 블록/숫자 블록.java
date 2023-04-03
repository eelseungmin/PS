class Solution {
    /*
    입출력 예를 보면 결과적으로 각 블록에 해당 인덱스의 약수 중 최댓값(인덱스 자기 자신은 제외)이 적혀야 한다.
    
    2부터 sqrt(n)까지 순회하면서 각 인덱스의 최대 약수 구하기
    */
    public int[] solution(long begin, long end) {
        int st = (int) begin;
        int en = (int) end;
        int[] ans = new int[en - st + 1];
        
        for (int i = st; i <= en; i++) {
            if (i == 1) {
                continue;
            }
            ans[i - st] = 1;
            
            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    ans[i - st] = i / j;
                    break;
                } else if (i % j == 0) {
                    ans[i - st] = j;
                }
            }
        }
        
        return ans;
    }
}