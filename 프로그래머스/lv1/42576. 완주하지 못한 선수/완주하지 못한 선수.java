import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> par = new HashMap();
        String answer = "";
        for( String s : participant ) {
           if(par.containsKey(s)){
               int n = par.get(s)+1;
               par.put(s, n);
           }
            else{
                par.put(s,1);
            }
        }
        
        for(String s : completion){
            int n = par.get(s) - 1;
            par.put(s, n);
        }
        
        Iterator<String> keys = par.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            if(par.get(key)>0)
                answer=key;
        }
        
        
       
        return answer;
    }
}