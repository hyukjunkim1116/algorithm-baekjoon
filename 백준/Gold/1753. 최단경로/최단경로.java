import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        ArrayList<Node>[] links = new ArrayList[N + 1];
        int[] dist = new int[N + 1];
        
        // 초기화
        for (int i = 1; i <= N; i++) {
            links[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            links[A].add(new Node(B, C));
        }
        
        // 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (dist[current.vertex] < current.weight) continue;
            
            for (Node next : links[current.vertex]) {
                if (dist[current.vertex] + next.weight < dist[next.vertex]) {
                    dist[next.vertex] = dist[current.vertex] + next.weight;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }
        System.out.print(sb);
    }
}
