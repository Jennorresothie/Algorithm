import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char c[];
    static boolean[] visied = new boolean[10];
    static String maxS="0", minS="9999999999";
    static boolean check(int a, int b, char c){
        if(a>b&&c=='>') return true;
        if(a<b&&c=='<') return true;
        return false;
    }
    static void dfs(int depth, String num) {

        if(depth>n){
            if(maxS.compareTo(num)<0){
                maxS = num;
            }
            if(minS.compareTo(num)>0){
                minS = num;
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(visied[i])
                continue;
            if(depth==0||check(num.charAt(depth-1)-'0',i,c[depth])){
                visied[i]=true;
                dfs(depth+1,num+(char)('0'+i));
                visied[i]=false;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        c = new char[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            c[i] = st.nextToken().charAt(0);
        }

        dfs(0,"");

        System.out.println(maxS);
        System.out.println(minS);
    }
}