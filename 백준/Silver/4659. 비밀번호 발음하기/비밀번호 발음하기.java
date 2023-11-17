import java.io.*;

public class Main {
    private static boolean isVow(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s = br.readLine();
       
        while (!s.equals("end")){
            boolean flag = false;
            int cons, vow, i;
            cons = vow = i = 0;
            char prev = '0';

            for(char c : s.toCharArray()) {

                if(isVow(c)){
                    flag = true;
                    cons ++;
                    vow = 0;
                }
                else {
                    cons = 0;
                    vow ++;
                }
                if(cons>2 || vow >2) {
                    flag = false;
                    break;
                }

                if(i>0&&prev==c&&!(prev=='e'||prev=='o')){
                    flag = false;
                    break;
                }
                prev = c;
                i++;
            }

            if(flag) {
                System.out.printf("<%s> is acceptable.\n",s);
            }
            else {
                System.out.printf("<%s> is not acceptable.\n",s);
            }

            s = br.readLine();
        }
    }
}