import java.io.*;

public class Main {

    public static void solution(String[] names){
        int[] arr = new int[26];

        for(String s: names){
            arr[s.charAt(0)-'a']++;
        }

        boolean flag = false;
        for(int i=0; i<26; i++){
            if(arr[i]>4){
                System.out.print((char)('a'+i));
                flag=true;
            }
        }
        if(!flag)
            System.out.println("PREDAJA");
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] names = new String[n];

        for(int i=0;i<n;i++){
            names[i]=br.readLine();
        }

        solution(names);

    }
}