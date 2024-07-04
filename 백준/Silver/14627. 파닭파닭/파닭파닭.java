import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[s];
        long total=0;
        for (int i=0; i<s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total+=arr[i];
        }

        int l=1, r=1000000000, ret=0;
        while(l<=r){
            int mid = (l+r)/2;
            int sum=0;
            for (int i : arr)
                sum+=i/mid;
            if(sum<c) r = mid-1;
            else {
                l = mid+1;
                ret = mid;
            }
        }
        total-=(long)ret*c;
        bw.write(String.valueOf((total)));
        bw.close();
    }
}