import java.util.*;
import java.io.*;

public class Main {
    // 답 보고 품 1
    static int indO, indN;
    static char[] operater = new char[10];
    static int[] nums = new int[11];

    static int max = Integer.MIN_VALUE;

    private static int cal(char op, int a, int b) {
        int re = 0;
        switch (op) {
            case '-':
                re= a-b;
                break;
            case '+':
                re= a+b;
                break;
            case '*':
                re= a*b;
                break;
        }

        return re;
    }

    private static void recur(int position, int val) {

        if(position == indO) {
            max = Math.max(max, val);
            return;
        }

        recur(position+1, cal(operater[position], val, nums[position+1] ));

        if(position+2<=indO){
            int temp = cal(operater[position+1], nums[position+1], nums[position+2]);
            recur(position+2, cal(operater[position], val, temp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        indO = indN = 0;
        // 수와 연산자 분리
        for(int i=0; i<n; i++) {
            char c = str.charAt(i);

            if(c=='+'||c=='-'||c=='*'){
                operater[indO++] = c;
            }
            else{
                nums[indN++] = Character.getNumericValue(c);
            }
        }

        recur(0, nums[0]);
        System.out.println(max);
    }
}