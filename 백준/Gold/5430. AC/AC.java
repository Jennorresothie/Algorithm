import java.io.*;
import java.util.*;

public class Main {
    static int nums[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test=0; test<t; test++){
            String p = br.readLine();
            int n = stoi(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),",[]");
            nums = new int[n];
            for(int j=0; j<n; j++) nums[j]=stoi(st.nextToken());
            int start=0, end=n-1;

            int top, flag = 0;
            for(char c : p.toCharArray()){
                if(c=='R')
                    flag^=(1<<0);
                else {
                    if(flag==0) start++;
                    else end--;
                    n--;
                }
            }

            if(n<0) {
                sb.append("error\n");
            }
            else {
                sb.append("[");
                if(flag==0){
                    for(int i=start; i<=end; i++){
                        sb.append(Integer.toString(nums[i]));
                        if(i<end)
                            sb.append(",");
                    }
                }
                else{
                    for(int i=end; i>=start; i--){
                        sb.append(Integer.toString(nums[i]));
                        if(i>start)
                            sb.append(",");
                    }
                }

                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int stoi(String str){
        return Integer.parseInt(str);
    }
}