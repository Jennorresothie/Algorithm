import java.io.*;

public class Main {
    static String stand;

    public static boolean check_front(String str, String front) {
        for(int i=0; i<front.length(); i++){
            if(str.charAt(i)!=front.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean check_back(String str, String back) {
        String reverse_back = new StringBuilder(back).reverse().toString();
        String reverse_str = new StringBuilder(str).reverse().toString();

        for(int i=0; i<back.length(); i++){
            if(reverse_str.charAt(i)!=reverse_back.charAt(i))
                return false;
        }
        return true;
    }

    public static void solution(String[] str){
        // *를 기준으로 앞괴 뒤를 나눔
        String front, back;
        front = stand.substring(0,stand.indexOf('*'));
        back = stand.substring(stand.indexOf('*')+1);

        for(String s : str) {
            if(front.length()+back.length()<=s.length()&&check_front(s,front)&&check_back(s, back))
                System.out.println("DA");
            else
                System.out.println("NE");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stand = br.readLine();
        String[] st = new String[n];
        for(int i=0;i<n;i++){
            st[i] = br.readLine();
        }

        solution(st);

    }
}