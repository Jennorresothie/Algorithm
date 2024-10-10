import java.io.*;
import java.util.*;
public class Main {
    static int n, c, arr[];
    static long ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 나뉘어 완전탐색
        ArrayList<Integer>  sum1 = new ArrayList<>();
        ArrayList<Integer>  sum2 = new ArrayList<>();

        go(0, 0, n/2, sum1);
        go(n/2, 0, n, sum2);

        // 정렬
        Collections.sort(sum2);

        for(Integer i : sum1)
            ret+=binarySearch(c-i, sum2)+1;

        bw.write(ret+"");
        bw.close();
    }

    static void go(int start, int sum, int end, ArrayList<Integer> list) {

        if(sum>c) return;
        if(start==end){
            list.add(sum);
            return;
        }

        // 넣기
        go(start+1, sum+arr[start], end, list);


        // 안 넣기
        go(start+1, sum, end, list);
    }

    public static int binarySearch(int target, ArrayList<Integer> sum){
        int left = 0, right = sum.size() - 1, answer = -1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if (sum.get(mid) <= target) {
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return answer;
    }
}