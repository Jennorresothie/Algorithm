import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int n, int k, int[] arr){
        int max = -20000000;
        int sum = 0;

        for(int i = 1; i <= n-k+1; i++){
            if(i==1) {
                for(int j = 1; j <= k; j++) {
                    sum += arr[j];
                }
            }
            else
                sum = sum - arr[i-1] + arr[i+k-1];
            max = max<sum?sum:max;
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[100001];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, k, arr);
    }
}