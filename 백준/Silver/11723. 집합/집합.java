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

            if(command.charAt(1)=='l'){
                s=(1<<20)-1;
            }
            else if(command.charAt(1)=='m') {
                s=0;
            }
            else{
                x = Integer.parseInt(st.nextToken());
                if(command.charAt(1)=='d') s|=(1<<(x-1));

                else if(command.charAt(1)=='e') s&=~(1<<(x-1));

                else if(command.charAt(1)=='h') sb.append((s&(1<<(x-1)))>0?1:0).append('\n');

                else if(command.charAt(1)=='o') s ^= (1<<(x-1));
            }
        }
        System.out.println(sb);
    }
}