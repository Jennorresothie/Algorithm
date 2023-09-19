import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for(int i=0; i<test_case; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 1;
            HashMap<String, Integer> clothes_map = new HashMap<>();
            for(int j=0; j<n; j++) {
                st = new StringTokenizer( br.readLine() );
                st.nextToken();
                String clothes = st.nextToken();
                clothes_map.put(clothes, clothes_map.getOrDefault(clothes,1)+1);
            }

            for(String s : clothes_map.keySet()){
                answer*=clothes_map.get(s);
            }

            System.out.println(answer-1);

        }

    }
}