class Solution {
    /*
    순열을 이용해서 주어진 프렌즈를 배열한 뒤 조건 확인
    조건이 충족되지 않았을 경우엔 순열로 재배열한 뒤 반복
    */
    static int num; // n
    static String[] d; // data
    static boolean[] isUsed;
    static char[] tmp;
    static int ans;

    public int solution(int n, String[] data) {
        num = n;
        d = data;
        isUsed = new boolean[8];
        tmp = new char[8];
        ans = 0;

        char[] friends = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        permu(0, friends);

        return ans;
    }

    public void permu(int k, char[] friends) { // 순열 구하기
        if (k == 8) {
            if (check()) { // 순열이 완성되면 조건 확인
                ans++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                tmp[k] = friends[i];
                permu(k + 1, friends);
                isUsed[i] = false;
            }
        }
    }

    public boolean check() {
        int first = 0;
        int second = 0;

        for (String td : d) {
            char c1 = td.charAt(0);
            char c2 = td.charAt(2);
            char op = td.charAt(3);
            int gap = td.charAt(4) - '0';

            switch (op) {
                case '=':
                    first = findIdx(c1);
                    second = findIdx(c2);
                    if (Math.abs(first - second) - 1 != gap) {
                        return false;
                    }
                    break;
                case '<':
                    first = findIdx(c1);
                    second = findIdx(c2);
                    if (Math.abs(first - second) - 1 >= gap) {
                        return false;
                    }
                    break;
                case '>':
                    first = findIdx(c1);
                    second = findIdx(c2);
                    if (Math.abs(first - second) - 1 <= gap) {
                        return false;
                    }
            }
        }

        return true; // 조건이 다 통과되면 true return
    }

    public int findIdx(char target) { // tmp 배열에서 target idx 찾기
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == target) {
                return i;
            }
        }

        return -1;
    }
}