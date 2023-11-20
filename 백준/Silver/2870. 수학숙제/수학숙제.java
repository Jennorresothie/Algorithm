import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        List<String> list = new LinkedList<>();

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            st = br.readLine();
            int s=0, end=1;
            boolean flag = false;
            for(int j=0; j<st.length(); j++){
                if('0'<=st.charAt(j)&&st.charAt(j)<='9'){
                    if(!flag){
                        s = j;
                    }
                    else if(true&&st.charAt(s)=='0')
                        s++;
                   flag = true;
                }
                else {
                    if(flag) {
                        list.add(st.substring(s,j));

                    }
                    flag = false;
                }
            }
            if(flag){
                list.add(st.substring(s,st.length()));
            }

        }

        list.sort((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());

        for(String i : list)
            System.out.println(i);

    }
}