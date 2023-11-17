import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s = br.readLine();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        Set<String> set2 = new HashSet<>();
        set2.add("ee");
        set2.add("oo");

        while (!s.equals("end")){
            boolean flag = false;
            int cons, vow;
            cons = vow = 0;
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.append(c);
                if(set.contains(c)){
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

                if(sb.length()==2){
                    if(sb.charAt(0)==sb.charAt(1)&&!set2.contains(sb.toString())){
                        flag = false;
                        break;
                    }
                    sb.deleteCharAt(0);
                }
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