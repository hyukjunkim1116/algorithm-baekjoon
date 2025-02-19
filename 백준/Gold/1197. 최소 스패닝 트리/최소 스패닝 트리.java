import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int weight, node;
        
        Edge(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            graph[A].add(new Edge(C, B));
            graph[B].add(new Edge(C, A));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 1));
        
        int answer = 0;
        int cnt = 0;
        
        while (!pq.isEmpty() && cnt < N) {
            Edge current = pq.poll();
            
            if (!visited[current.node]) {
                visited[current.node] = true;
                answer += current.weight;
                cnt++;
                
                for (Edge next : graph[current.node]) {
                    if (!visited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}
