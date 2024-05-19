import java.io.*;
import java.util.*;
public class Main {
    static int arr[], brr[], ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new int[a];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) arr[i] = Integer.parseInt(st.nextToken());
        brr = new int[b];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++) brr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int A : arr) if(check(A, brr)) ret++;
        for(int B : brr) if(check(B, arr)) ret++;
        bw.write(String.valueOf(ret));
        bw.close();
    }
    static boolean check(int n, int[] array) {
        int l = 0, r = array.length - 1;
        while(l<=r) {
            int mid = (l+r) / 2;
            if(array[mid]>n) r = mid - 1;
            else if(array[mid]==n) return false;
            else l = mid + 1;
        }
        return true;
    }
}