import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // 규칙을 찾아 문제를 해결
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        // 정점별 in, out 개수 파악
        for(int[] e : edges) {
            out.put(e[0], out.getOrDefault(e[0], 0) + 1);
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
        }
        
        /*
        1. 8자 그래프는 나가는 것과 들어오는 것 각가 2개이다
        2. 생성된 점은 나가는 점이 2개 이상이고 들어오는 점이 없다
        */
        
        for (int o : out.keySet()) {
            if(out.get(o)>1) {
                if(!in.containsKey(o))
                    answer[0] = o; // 생성된 점
                
                else  // 8자 그래프
                    answer[3]++;
            }
        }
        
        // 막대그래프는 들어오는 정점이 하나이고 나가는 정점이 없다 혹은 나가는 정점이 1개이고 들어오는 정점이 없다
        for ( int i : in.keySet() ) {
            if(!out.containsKey(i))
                answer[2] ++;
        }
        
        // 생성된 정점의 개수 = 그래프의 총 개수
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        
        return answer;
    }
}