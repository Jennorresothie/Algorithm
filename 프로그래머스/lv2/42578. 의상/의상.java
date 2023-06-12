import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap();
        
        for(String[] s : clothes)
            map.put(s[1], map.getOrDefault(s[1],1)+1);
        
        int total=1;
        for(String s : map.keySet()){
            total*=map.get(s);
        }
        answer=total-1;
        return answer;
    }
}