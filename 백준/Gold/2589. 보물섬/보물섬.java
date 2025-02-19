import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        
        // 그래프 입력
        int landCount = 0;
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
                if(graph[i][j] == 'L') landCount++;
            }
        }
        
        // 육지가 1개 이하면 종료
        if(landCount <= 1) {
            System.out.println(0);
            return;
        }
        
        int maxi = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(graph[y][x] == 'L') {
                    maxi = Math.max(maxi, bfs(y, x));
                }
            }
        }
        
        System.out.println(maxi);
    }
    
    static int bfs(int startY, int startX) {
        Set<Point> visited = new HashSet<>();
        int[][] dist = new int[n][m];
        Queue<Point> q = new LinkedList<>();
        
        Point start = new Point(startY, startX);
        visited.add(start);
        q.offer(start);
        int maxDist = 0;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                Point next = new Point(ny, nx);
                
                if(ny >= 0 && ny < n && nx >= 0 && nx < m 
                   && graph[ny][nx] == 'L' && !visited.contains(next)) {
                    visited.add(next);
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    maxDist = Math.max(maxDist, dist[ny][nx]);
                    q.offer(next);
                }
            }
        }
        return maxDist;
    }
    
    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Point)) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
