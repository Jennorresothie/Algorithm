import java.io.*;

public class Main {
    static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        String bomb = br.readLine();
        int bsize = bomb.length();
        StringBuilder sb = new StringBuilder();
        for(char c: str){
            sb.append(c);
            if(sb.length()>=bsize){
                if(sb.substring(sb.length()-bsize).equals(bomb)){
                    sb.replace(sb.length()-bsize,sb.length(),"");
                }
            }

        }
        System.out.println(sb.length()==0?"FRULA":sb);
    }
}