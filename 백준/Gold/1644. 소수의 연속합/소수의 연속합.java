import java.io.*;
import java.util.*;

public class Main {
    static int sum, st, end, ret, ind, primenum[]=new int[300000];
    static boolean prime[] = new boolean[4000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Eratos();
        for(int i=2; i<=n; i++) if(prime[i]) primenum[ind++]=i;

        while(true) {
            if(sum >= n) sum -= primenum[st++];
            else if(end==ind) break;
            else sum+=primenum[end++];
            if(sum==n) ret++;
        }
           System.out.println(ret);
    }
    static void Eratos() {
        Arrays.fill(prime, 2, 4000001, true);

        for (int i=2; (i*i)<=4000000; i++) {
            if(prime[i]==true) {
                for(int j=i*i; j<=4000000; j+=i) prime[j]=false;
            }
        }
    }
}