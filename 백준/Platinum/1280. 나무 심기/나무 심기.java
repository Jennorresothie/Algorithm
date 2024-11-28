import java.io.*;
import java.util.*;
public class Main {
    static int mod = 1000000007, max_n = 200001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long answer = 1;
        Long arr[] = new Long[200002];
        Arrays.fill(arr, 0l);
        ArrayList<Long> tree_cnt = new ArrayList<>(List.of(arr));
        ArrayList<Long> tree_sum = new ArrayList<>(List.of(arr));

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine())+1;

            if (i>0) {
                long left = num * interval(tree_cnt, 1, num-1) - interval(tree_sum, 1, num-1);
                long right = interval(tree_sum, num+1, max_n) - num * interval(tree_cnt, num+1, max_n);

                answer *= (left + right) % mod;
                answer %= mod;
            }
            update(tree_cnt, num, 1);
            update(tree_sum, num, num);
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static long prefix(ArrayList<Long> list, int n) { // 누적합 계산
        long ret = 0;
        int i = n;
        while (i>0) {
            ret += list.get(i);
            i -= (i & -i);
        }

        return ret;
    }

    static long interval(ArrayList<Long> list, int start, int end) { // 구간합 계산
        if (start > end) return 0;
        return (prefix(list, end) - prefix(list, start-1));
    }

    static void update(ArrayList<Long> list, int n, long dif) { // 삽입
        int i=n;
        while (i<=max_n) {
            long temp = list.get(i) + dif;
            list.set(i, temp);
            i += (i & -i);
        }
    }

}