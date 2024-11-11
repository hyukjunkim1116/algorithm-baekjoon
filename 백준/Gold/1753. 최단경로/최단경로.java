import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph; // 그래프를 저장할 인접 리스트
    static int[] dist; // 최단 거리를 저장할 배열
    
    // 노드 클래스 정의
    static class Node implements Comparable<Node> {
        int vertex, weight; // 정점과 가중치
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        // 우선순위 큐에서 가중치 기준으로 정렬하기 위한 비교 메서드
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 정점의 개수 V와 간선의 개수 E 입력
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        // 시작 정점 K 입력
        int K = sc.nextInt();
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 거리 배열 초기화
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        
        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
        }
        
        // 다익스트라 알고리즘 수행
        dijkstra(K);
        
        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    
    // 다익스트라 알고리즘 구현
    static void dijkstra(int start) {
        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 시작 정점의 거리를 0으로 설정
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;
            
            // 현재 거리가 이미 저장된 거리보다 크면 스킵
            if (dist[curVertex] < curWeight) continue;
            
            // 현재 정점과 연결된 모든 정점들을 검사
            for (Node next : graph.get(curVertex)) {
                // 새로운 거리 계산
                int newDist = dist[curVertex] + next.weight;
                
                // 새로운 거리가 기존 거리보다 작으면 업데이트
                if (newDist < dist[next.vertex]) {
                    dist[next.vertex] = newDist;
                    pq.offer(new Node(next.vertex, newDist));
                }
            }
        }
    }
}