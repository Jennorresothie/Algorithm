import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int s=0, n, x;

        n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    s|=(1<<(x-1));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    s&=~(1<<(x-1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((s&(1<<(x-1)))>0?1:0).append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    s ^= (1<<(x-1));
                    break;
                case "all":
                    s=(1<<20)-1;
                    break;
                case "empty":
                    s=0;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}