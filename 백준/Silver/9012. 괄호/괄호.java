import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            String ps = br.readLine();
            int ret = 0;

            for(Character c : ps.toCharArray()){
                if(c=='(')
                    ret++;
                else if(c==')')
                    ret--;
                if(ret<0)
                    break;
            }
            System.out.println(ret==0?"YES":"NO");
        }
    }
}