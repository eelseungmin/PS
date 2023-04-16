class Solution
{
    /*
    주어진 A, B를 다음 숫자로 바꾸는 메서드 작성
    A가 짝수면 /2, 홀수면 +1 /2 
    
    맞붙는지 확인하는 방법
    A + 1 = B or B + 1 = A
    A < B
    A % 2 = 1
    B < A
    B % 2 = 1
    */
    static int ans;
    
    public int solution(int n, int a, int b)
    {
        ans = 0;
        
        if (a < b) {
            fight(a, b);
        } else {
            fight(b, a);
        }
        
        return ans;
    }
    
    // x < y
    void fight(int x, int y) {
        if (check(x, y)) {
            ans++;
            return;
        }
        
        int nx = 0;
        int ny = 0;
        if (x % 2 == 0) {
            nx = x / 2;
        } else {
            nx = (x + 1) / 2;
        }
        if (y % 2 == 0) {
            ny = y / 2;
        } else {
            ny = (y + 1) / 2 ;
        }
        
        ans++;
        fight(nx, ny);
    }
    
    boolean check(int x, int y) {
        if (y - x == 1 && x % 2 == 1) {
            return true;
        }
        
        return false;
    }
}