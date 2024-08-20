import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Integer> stand = new ArrayList<>();
    static int index, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        Collections.sort(list, (o1, o2)-> o1[0]-o2[0]);
        arr = new int[n];
        for (int i=0; i<n; i++) {
            int second = list.get(i)[1];
            if(stand.isEmpty()||stand.get(stand.size()-1)<second) {
                stand.add(second);
                arr[i] = index++;
            }else {
                int l = 0;
                int r = stand.size() - 1;
                while(l<r) {
                    int mid = (l+r) >> 1;
                    if(stand.get(mid)>=second) r = mid;
                    else l = mid + 1;
                }
                stand.set(r, second);
                arr[i] = r;
            }
        }
        int answer = n - stand.size();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}