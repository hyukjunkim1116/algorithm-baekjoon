import java.io.*;
import java.util.*;

public class Main {
    // N: 도시의 개수, M: 버스 노선의 개수
    static int N, M;
    // 모든 간선(버스 노선) 정보를 저장할 리스트
    static List<Edge> edges = new ArrayList<>();
    // 각 도시까지의 최단 거리를 저장할 배열
    static long[] dist;
    // 무한대 값 설정
    static final long INF = Long.MAX_VALUE;
    
    // 간선(버스 노선) 정보를 저장할 클래스
    static class Edge {
        int from, to;    // from: 출발 도시, to: 도착 도시
        long cost;       // cost: 이동하는데 걸리는 시간
        
        // Edge 클래스 생성자
        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄에서 N과 M을 공백으로 구분하여 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 도시의 개수와 버스 노선의 개수 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 최단 거리 배열 초기화 (1번부터 N번 도시까지)
        dist = new long[N + 1];
        
        // M개의 버스 노선 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());    // 출발 도시
            int b = Integer.parseInt(st.nextToken());    // 도착 도시
            long c = Long.parseLong(st.nextToken());    // 이동 시간
            edges.add(new Edge(a, b, c));               // 간선 리스트에 추가
        }
        
        // 벨만-포드 알고리즘 실행 및 결과 출력
        if (bellmanFord()) {
            // 음수 사이클이 존재하면 -1 출력
            System.out.println(-1);
        } else {
            // 2번 도시부터 N번 도시까지의 최단 거리 출력
            for (int i = 2; i <= N; i++) {
                // 도달할 수 없는 경우 -1, 가능한 경우 최단 거리 출력
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        }
    }
    
    // 벨만-포드 알고리즘 구현
    static boolean bellmanFord() {
        // 모든 거리를 무한대로 초기화
        Arrays.fill(dist, INF);
        // 시작점(1번 도시)의 거리는 0으로 설정
        dist[1] = 0;
        
        // (N-1)번 반복하여 최단 거리 갱신
        for (int i = 1; i < N; i++) {
            for (Edge edge : edges) {
                // 출발 도시에 도달할 수 없는 경우 스킵
                if (dist[edge.from] == INF) continue;
                // 더 짧은 경로를 발견한 경우 거리 갱신
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }
        
        // 음수 사이클 검사
        for (Edge edge : edges) {
            // 출발 도시에 도달할 수 없는 경우 스킵
            if (dist[edge.from] == INF) continue;
            // 음수 사이클이 존재하는 경우
            if (dist[edge.to] > dist[edge.from] + edge.cost) {
                return true;    // 음수 사이클 발견
            }
        }
        
        return false;    // 음수 사이클 없음
    }
}