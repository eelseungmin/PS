import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        // 사전 초기화
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
        map.put("N", 14);
        map.put("O", 15);
        map.put("P", 16);
        map.put("Q", 17);
        map.put("R", 18);
        map.put("S", 19);
        map.put("T", 20);
        map.put("U", 21);
        map.put("V", 22);
        map.put("W", 23);
        map.put("X", 24);
        map.put("Y", 25);
        map.put("Z", 26);
        
        while (msg.length() != 0) {
            String cur = msg;
            String next = "";
            
            while (!map.containsKey(cur)) {
                next = cur.substring(cur.length() - 1); // 다음 글자 미리 저장
                cur = cur.substring(0, cur.length() - 1); // 끝에서부터 하나씩 자르기
            }
            
            ans.add(map.get(cur)); // 색인 번호 출력
            map.put(cur + next, map.size() + 1); // 현재 문자열 + 다음 글자 사전에 등록
            msg = msg.substring(cur.length());
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}