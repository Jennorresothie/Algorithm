import java.io.*;
import java.util.*;
public class Main {
    static class LinkNode {
        int score;
        LinkNode redNext;
        LinkNode blueNext;
        boolean isHorse;

        public LinkNode(int score){
            this.score = score;
        }
    }

    static class Horse {
        boolean isDone;
        LinkNode nodeInd = startNode;
    }

    static LinkNode startNode, endNode;
    static Horse horse[] = new Horse[4];
    static int dices[] = new int[10], ret;
    static void makeBlueNext(LinkNode start, LinkNode end, int step, int cnt) {
        for(int i=0; i<cnt; i++) {
            start.redNext = new LinkNode(start.score+step);
            start = start.redNext;
        }
        start.redNext = end;
    }

    static void permutation(int depth, int sum) {
        if(depth==10) {
            ret = Math.max(ret, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            if(horse[i].isDone) continue;
            LinkNode temp = horse[i].nodeInd;
            for(int j=0; j<dices[depth]; j++) {
                if(j==0&&temp.blueNext!=null)
                    temp = temp.blueNext;
                else
                    temp = temp.redNext;

                if(temp.equals(endNode)) break;
            }
            if(temp != endNode && temp.isHorse==true) continue;

            boolean isDone = horse[i].isDone;
            if(temp.equals(endNode)) horse[i].isDone=true;

            LinkNode cur = horse[i].nodeInd;
            cur.isHorse = false;
            temp.isHorse = true;
            horse[i].nodeInd = temp;

            permutation(depth+1, sum + temp.score);

            horse[i].isDone = isDone;
            horse[i].nodeInd = cur;
            cur.isHorse = true;
            temp.isHorse = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        startNode = new LinkNode(0);
        endNode = new LinkNode(0);
        LinkNode crossNode = new LinkNode(25);

        LinkNode pre = startNode;
        for(int i=1; i<=20; i++) {
            pre.redNext = new LinkNode(i*2);

            if(i==6) {
                pre.blueNext = new LinkNode(13);
                makeBlueNext(pre.blueNext, crossNode, 3, 2);
            }
            else if(i==11){
                pre.blueNext = new LinkNode(22);
                makeBlueNext(pre.blueNext, crossNode, 2, 1);
            }
            else if(i==16){
                pre.blueNext = new LinkNode(28);
                makeBlueNext(pre.blueNext, crossNode, -1, 2);
            }
            pre = pre.redNext;
        }
        makeBlueNext(crossNode, pre, 5,2);
        pre.redNext = endNode;

        for(int i=0; i<horse.length; i++) horse[i] = new Horse();

        String[] strs = br.readLine().split(" ");
        for(int i=0; i<10; i++) dices[i] = Integer.parseInt(strs[i]);

        permutation(0, 0);
        bw.write(String.valueOf(ret));
        bw.close();

    }
}