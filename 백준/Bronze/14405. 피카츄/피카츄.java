import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean flag = true;
        int size = s.length();

        for(int i=0; i<size; i++) {

            if(i+1<size&& (s.substring(i, i+2).equals("pi")||s.substring(i,i+2).equals("ka")))
                i++;
            else if(i+2<size&& (s.substring(i,i+3).equals("chu")))
                i+=2;
            else{
                flag=false;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
    }
}