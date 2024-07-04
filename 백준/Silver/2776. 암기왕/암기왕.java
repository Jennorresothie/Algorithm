import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test=0; test<t; test++) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++)
                set.add(Integer.parseInt(st.nextToken()));
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++) {
                if(set.contains(Integer.parseInt(st.nextToken()))) bw.write("1\n");
                else bw.write("0\n");
            }
        }
        bw.close();
    }
}