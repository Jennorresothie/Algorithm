import java.io.*;
import java.util.*;
public class Main {
    static int ret, arr[], head, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        end = n-1;
        while(head<end){
            int temp = arr[head] + arr[end];
            if(temp<x) head++;
            else if(temp>x) end--;
            else {
                ret++;
                head++;
                end--;
            }
        }
        System.out.println(ret);
    }
}