import java.util.*;
class Solution {
    int n, m, visit[][], ex, ey, sx, sy;
    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        visit = new int[n][m]; 
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char c = board[i].charAt(j);
                if(c=='R') {
                    sx = j;
                    sy = i;
                }
                else if(c=='G') {
                    ey = i;
                    ex = j;
                }
                else if(c=='D')
                    visit[i][j] = -1;
            }
        }
        
        if(bfs(sx, sy)) answer=visit[ey][ex]-1;
        
        
        return answer;
    }
    
    boolean bfs(int x, int y) {
        int dire[][] = {{-1,0},{0,1},{0,-1},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur[1];
                int ny = cur[0];
                
                while((nx>-1&&nx<m&&ny>-1&&ny<n) && !(visit[ny][nx]==-1)) {
                    nx += dire[i][1];
                    ny += dire[i][0];
                }
                
                nx -= dire[i][1];
                ny -= dire[i][0];
                
                if(visit[ny][nx]>0) continue;
                
                q.add(new int[]{ny, nx});
                visit[ny][nx] = visit[cur[0]][cur[1]] + 1;
                if(ny==ey&&nx==ex) return true;
            }
        }
        return false;
    }
}