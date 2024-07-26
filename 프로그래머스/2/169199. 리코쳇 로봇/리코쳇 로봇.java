import java.util.*;
class Solution {
    int visited[][];
    int n, m, end[];
    Queue<int[]> q = new LinkedList<>();
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        visited = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i].charAt(j)=='R') {
                    q.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
                else if(board[i].charAt(j)=='G') 
                    end = new int[]{i, j};
                
                else if(board[i].charAt(j)=='D')
                    visited[i][j] = -1;
            }
        }
        
        if(bfs()) answer = visited[end[0]][end[1]] - 1; 
        else answer = -1;
        
        return answer;
    }
    
    boolean bfs() {
        int dire[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            
            for(int i=0; i<4; i++) {
                int dy = cur[0];
                int dx = cur[1];
                
                while(!(dx<0||dx>=m||dy<0||dy>=n) && !(visited[dy][dx]==-1)) {
                    dy += dire[i][0];
                    dx += dire[i][1];
                }
                dy -= dire[i][0];
                dx -= dire[i][1];
                
                if((cur[0]==dy&&cur[1]==dx)||visited[dy][dx]>0) continue;
                q.add(new int[]{dy, dx});
                visited[dy][dx] = visited[cur[0]][cur[1]] + 1;
                if((end[0]==dy)&&(end[1]==dx)) return true;
            }
        }
        return false;
    }
    
}