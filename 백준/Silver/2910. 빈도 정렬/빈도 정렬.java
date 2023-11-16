import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n,c;
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer[]> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(map.containsKey(temp)){
                map.put(temp,new Integer[] {map.get(temp)[0]+1,map.get(temp)[1]});
                continue;
            }
            map.put(temp, new Integer[] {1,i});
            i++;
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        //Value값으로 오름차순 정렬
        keySet.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o2)[0]==map.get(o1)[0])
                    return map.get(o1)[1].compareTo(map.get(o2)[1]);
                return map.get(o2)[0].compareTo(map.get(o1)[0]);
            }
        });

        for(Integer key : keySet) {
            for(int j=0; j< map.get(key)[0]; j++)
                System.out.print(key+" ");
        }
    }
}