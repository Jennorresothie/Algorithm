import java.io.*;

public class Main {
    public static void solution(String str) {
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if('a'<=c&&c<='z'){
                c = (char)(c+13);
                if(c>'z')
                    c = (char)((c%('z'+1))+'a');
            }
            else if('A'<=c&&c<='Z'){
                c = (char)(c+13);
                if(c>'Z')
                    c = (char)((c%('Z'+1))+'A');
            }
            sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        solution(str);
    }
}