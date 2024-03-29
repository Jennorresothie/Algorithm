import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        String[] poket = new String[n+1];

        String name;
        for(int i=1; i<=n; i++) {
            name = br.readLine();
            nameMap.put(name, i);
            poket[i] = name;
        }

        for(int i=0; i<m; i++){
            String cmd = br.readLine();
            if('0'<=cmd.charAt(0)&&cmd.charAt(0)<='9'){
                int num = Integer.parseInt(cmd);
                System.out.println(poket[num]);
            }
            else{
                System.out.println(nameMap.get(cmd));
            }
        }

    }
}