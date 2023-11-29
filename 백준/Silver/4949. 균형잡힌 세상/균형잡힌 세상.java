import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            boolean flag = true;
            if(str.equals("."))
                break;

            Stack<Character> s = new Stack<>();

            for(char c : str.toCharArray()){

                if(c=='('||c=='[')
                    s.add(c);

                else if(c==')'||c==']'){
                    if(s.empty()){
                        flag = false;
                        break;
                    }

                    char cc = s.pop();
                    if(c==')') {
                        if(!(cc == '(')){
                            flag = false;
                            break;
                        }
                    }
                    else if(c==']') {
                        if(!(cc == '[')){
                            flag = false;
                            break;
                        }
                    }

                }
            }
            if(!s.empty())
                flag = false;


            System.out.println(flag?"yes":"no");
        }
    }
}