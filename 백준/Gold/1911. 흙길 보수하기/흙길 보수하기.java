import java.io.*;
import java.util.*;
public class Main {
    static int n, l, ret;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int pre=0;
        for(int[] dump : list) {
            if(pre>=dump[1]) continue;
            int start = pre>dump[0]?pre:dump[0];
            int a = (dump[1]-start)/l + ((dump[1]-start)%l>0?1:0);
            ret += a;
            pre = start + a*l;

        }
        bw.write(String.valueOf(ret));
        bw.close();
    }
}