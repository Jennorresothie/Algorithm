import java.io.*;
public class Main {
    static class LinkNode {
        int score;
        LinkNode redLine;
        LinkNode blueLine;
        boolean isHorse;

        public LinkNode(int score){
            this.score = score;
        }
    }

    static class Horse {
        boolean isFinish;
        LinkNode 현재위치 = startNode;
    }

    static LinkNode startNode, endNode;
    static int dices[] = new int[10], ret;
    static Horse[] horses = new Horse[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        startNode = new LinkNode(1);
        endNode = new LinkNode(0);
        LinkNode crossNode = new LinkNode(25);

        // 초기화
        LinkNode 이전노드 = startNode;
        for(int i=1; i<21; i++) {
            이전노드.redLine = new LinkNode(i*2);

            if(i==6) {
                이전노드.blueLine = new LinkNode(13);
                makeLine(이전노드.blueLine, crossNode, 3, 2);
            }
            else if(i==11) {
                이전노드.blueLine = new LinkNode(22);
                makeLine(이전노드.blueLine, crossNode, 2, 1);
            }
            else if(i==16) {
                이전노드.blueLine = new LinkNode(28);
                makeLine(이전노드.blueLine, crossNode, -1, 2);
            }
            이전노드 = 이전노드.redLine;
        }
        makeLine(crossNode, 이전노드, 5, 2);
        이전노드.redLine = endNode;

        for(int i=0; i<4; i++) horses[i] = new Horse();

        String[] strs = br.readLine().split(" ");
        for(int i=0; i<10; i++) dices[i] = Integer.parseInt(strs[i]);

        permutation(0, 0);
        bw.write(String.valueOf(ret));
        bw.close();

    }

    static void makeLine(LinkNode cur, LinkNode end, int step, int cnt) {
        for(int i=0; i<cnt; i++) {
            cur.redLine = new LinkNode(cur.score+step);
            cur = cur.redLine;
        }
        cur.redLine = end;
    }

    static void permutation(int depth, int sum) {
        if(depth==10) {
            ret = Math.max(ret, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            if(horses[i].isFinish) continue;

            LinkNode temp = horses[i].현재위치;

            for(int j=0; j<dices[depth]; j++) { // 말 이동
                if(j==0&&temp.blueLine!=null) temp = temp.blueLine;
                else temp = temp.redLine;

                if(temp == endNode) break;
            }

            if(temp != endNode && temp.isHorse) continue; // 말 이동후 말 겹치는지 확인

            // 말 이동 후 작업
            boolean 도착상태저장 = horses[i].isFinish;
            if(temp==endNode) horses[i].isFinish = true;

            // 이동 처리 - 현재 위치 표시 지우고 이동한 곳 표시
            LinkNode current = horses[i].현재위치;
            current.isHorse = false;
            temp.isHorse = true;
            horses[i].현재위치 = temp;

            permutation(depth+1, sum + temp.score);

            horses[i].isFinish = 도착상태저장;
            horses[i].현재위치 = current;
            current.isHorse = true;
            temp.isHorse = false;
        }
    }
}