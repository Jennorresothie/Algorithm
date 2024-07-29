import java.util.*;
import java.io.*;
public class Main {
    // LIS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(); // 현재 몇번째 큰 수 인가 판별용
        int arr[] = new int[n]; // 크기 저장용
        int nums[] = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        list.add(0);
        int ind = 0;
        for (int e : nums) {
            if(list.size()==1||list.get(list.size()-1)<e) { // 큰 값이면 그냥 넣기
                list.add(e);
                arr[ind++] = list.size() - 1;
            }
            else {
                int l = 1;
                int r = list.size();

                while(l<r) {
                    int mid = (l+r)>>1;
                    if(list.get(mid)>=e) r = mid;
                    else l = mid+1;
                }
                list.set(r, e);
                arr[ind++] = r;
            }
        }

        int len  = list.size() - 1;
        int arr2[] = new int[len];
        sb.append(len).append("\n");
        for(int i=n-1; i>-1; i--) {
            if(len == arr[i]) {
                len--;
                arr2[len] = nums[i];
            }
        }

        for(int i : arr2)
            sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.close();
    }
}