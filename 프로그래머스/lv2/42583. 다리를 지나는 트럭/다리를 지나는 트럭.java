import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> wait = new LinkedList<>(); // 대기 트럭
        Queue<Truck> exit = new LinkedList<>(); // 다리를 지난 트럭
        Queue<Truck> bridge = new LinkedList<>(); // 다리를 건너는 트럭
        for (int t : truck_weights) {
            wait.offer(t);
        }
        
        int bw = 0; // 다리에 올라간 트럭의 무게 총합
        int answer = 0;
        while (exit.size() < truck_weights.length) {
            answer++; // 시간 경과
            
            if (!bridge.isEmpty()) { // 다리에 트럭이 있을 경우
                if (answer - bridge.peek().start >= bridge_length) {
                    bw -= bridge.peek().weight;
                    exit.offer(bridge.poll()); // 조건을 만족하면 다리에서 내보내기
                }
            }
            
            if (!wait.isEmpty() && wait.peek() + bw <= weight) { // 대기 중인 트럭이 있다면 다리에 진입시키기
                Truck t = new Truck(wait.poll(), answer);
                
                bw += t.weight;
                bridge.offer(t);
            }
        }
        
        return answer;
    }
    
    class Truck {
        int weight, start;
        
        Truck(int weight, int start) {
            this.weight = weight;
            this.start = start;
        }
    }
}