import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean flag = true;
        int size = s.length();

        for(int i=0; i<size; i++) {
            switch(s.charAt(i)) {
                case 'p':
                    if(i+1<size&&s.charAt(i+1)=='i')
                        i++;
                    else flag=false;
                    break;
                case 'k':
                    if(i+1<size&&s.charAt(i+1)=='a')
                        i++;
                    else flag=false;
                    break;
                case 'c':
                    if(i+2<size&&s.charAt(i+1)=='h'&&s.charAt(i+2)=='u')
                        i+=2;
                    else flag=false;
                    break;
                default:
                    flag=false;
                    break;
            }
            if(!flag)
                break;
        }
        System.out.println(flag?"YES":"NO");
    }
}