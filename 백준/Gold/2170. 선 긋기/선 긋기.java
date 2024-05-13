import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, ret=0;
        List<int[]> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x,y});
        }
        list.sort(new Comparator<int[]> (){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        int st, end;
        st = list.get(0)[0];
        end = list.get(0)[1];
        for(int i=1; i<n; i++) {
            if(end<list.get(i)[0]) {
                ret += end - st;
                st = list.get(i)[0];
                end = list.get(i)[1];
            }
            else if(end<list.get(i)[1])
                end = list.get(i)[1];
        }
        ret += end - st;
        bw.write(String.valueOf(ret));
        bw.close();
    }
}