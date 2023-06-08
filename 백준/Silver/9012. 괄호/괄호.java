import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] g = new String[n];
        for(int i=0;i<n;i++){
            g[i] = br.readLine();
        }

        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<g[i].length();j++){
                if(g[i].charAt(j)=='(')
                    flag++;
                else
                    flag--;
                if(flag<0)
                    break;
            }
            System.out.println(flag==0?"YES":"NO");
        }
    }
}