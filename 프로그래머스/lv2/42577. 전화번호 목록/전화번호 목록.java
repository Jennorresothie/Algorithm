import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap();
        for(String s : phone_book)
            map.put(s,1);
        for(String s : phone_book){
            for(int i=1;i<s.length();i++){
                if(map.containsKey(s.substring(0,i))){
                    answer=false;
                    break;
                }
                    
            }
            if(!answer)
                break;
        }
        return answer;
    }
}