import java.io.*;
import java.util.*;
public class Main {
    static int n, ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int size = chars.length;
        boolean[] check = new boolean[size];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<size; i++){
            if(chars[i]=='(') s.push(i);
            else if(chars[i]==')'&&!s.empty())
                check[s.pop()]=check[i]=true;
        }

        int cnt=0;
        for(boolean b: check){
            if(b){
                cnt++;
                ret = Math.max(cnt,ret);
            }

            else cnt=0;

        }

        System.out.println(ret);
    }
}