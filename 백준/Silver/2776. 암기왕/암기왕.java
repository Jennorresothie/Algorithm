import java.io.*;
import java.util.*;
public class Main {
    static int [] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr1 = new int[1000001];
        arr2 = new int[1000001];
        int t = Integer.parseInt(br.readLine());
        for (int test=0; test<t; test++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++)
                arr1[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++)
                arr2[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr1, 0, n);
            for (int i=0; i<m; i++) {
                if(search(n, arr2[i])) bw.write(String.valueOf("1\n"));
                else bw.write(String.valueOf("0\n"));
            }
        }
        bw.close();
    }
    static boolean search(int n, int num) {
        int l=0, r=n-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(num==arr1[mid]) return true;
            if(num>arr1[mid]) l = mid+1;
            else r=mid-1;
        }
        return false;
    }
}