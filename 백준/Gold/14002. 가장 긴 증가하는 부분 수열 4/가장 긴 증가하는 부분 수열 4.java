import java.util.*;
import java.io.*;
public class Main {
    static int arr[], indexes[], index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        indexes = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++) {
            int a = arr[i];
            if(list.isEmpty()||list.get(list.size()-1)<a) {
                list.add(a);
                indexes[i] = index++;
            }else {
                int l = 0;
                int r = list.size() - 1;
                while(l<r) {
                    int mid = (l+r) >> 1;
                    if(list.get(mid)>=a) r = mid;
                    else l = mid + 1;
                }
                list.set(r, a);
                indexes[i] = r;
            }
        }
        int len = list.size();
        bw.write(String.valueOf(len)+'\n');
        int answer[] = new int[len--];
        for(int i=n-1; i>-1; i--) {
            if(len==indexes[i])
                answer[len--] = arr[i];

        }
        for (int i : answer)
            bw.write(String.valueOf(i)+' ');
        bw.flush();
        bw.close();
    }
}