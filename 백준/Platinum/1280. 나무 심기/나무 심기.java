import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000007, max_n = 200002;
        long ret=1;
        Long arr[] = new Long[200004];
        Arrays.fill(arr, 0L);
        ArrayList<Long> tree_cnt = new ArrayList<>(List.of(arr));
        ArrayList<Long> tree_sum = new ArrayList<>(List.of(arr));

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine())+1;

            if (i>0) {
                long left = num * sum(tree_cnt, 1, num-1) - sum(tree_sum, 1, num-1);
                long right = sum(tree_sum, num+1, max_n) - num * sum(tree_cnt, num+1, max_n);

                ret *= (left+right) % mod;
                ret %= mod;
            }
            update(tree_cnt, num, 1);
            update(tree_sum, num, num);
        }
        bw.write(ret+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static long prefix(ArrayList<Long> list, int n) {
        long ret = 0;
        int i = n;
        while (i>0) {
            ret += list.get(i);
            i -= (i & -i);
        }
        return ret;
    }

    static long sum(ArrayList<Long> list, int start, int end) {
        if (start > end) return 0;
        return (prefix(list, end) - prefix(list, start-1));
    }

    static void update(ArrayList<Long> list, int n, long dif){
        int i = n;
        while (i <= 200002) {
            long temp = list.get(i) + dif;
            list.set(i, temp);
            i += (i & -i);
        }

    }
}