import java.io.*;
import java.util.*;

public class Main {
    // 무한대 값 설정 (최대 거리 10000 * 정점 수 400 보다 큰 값)
    static final int INF = 4000001;
    // 정점(마을)의 수
    static int V;
    // 간선(도로)의 수
    static int E;
    // 각 정점 간의 최단 거리를 저장할 2차원 배열
    static int[][] dist;
    
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄의 입력을 공백으로 구분하여 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 정점의 수 V 입력
        V = Integer.parseInt(st.nextToken());
        // 간선의 수 E 입력
        E = Integer.parseInt(st.nextToken());
        
        // V+1 크기의 2차원 배열 생성 (1번부터 V번까지 사용)
        dist = new int[V + 1][V + 1];
        
        // 거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;  // 자기 자신으로의 거리는 0
                } else {
                    dist[i][j] = INF;  // 나머지는 무한대로 초기화
                }
            }
        }
        
        // E개의 간선 정보 입력
        for (int i = 0; i < E; i++) {
            // 각 줄의 입력을 공백으로 구분
            st = new StringTokenizer(br.readLine());
            // 출발 정점 a
            int a = Integer.parseInt(st.nextToken());
            // 도착 정점 b
            int b = Integer.parseInt(st.nextToken());
            // a에서 b로 가는 거리 c
            int c = Integer.parseInt(st.nextToken());
            // a에서 b로 가는 거리를 c로 설정
            dist[a][b] = c;
        }
        
        // 플로이드-워셜 알고리즘으로 모든 정점 쌍 사이의 최단 거리 계산
        floydWarshall();
        
        // 최소 사이클의 길이 찾기
        int answer = findMinimumCycle();
        
        // 결과 출력
        System.out.println(answer);
    }
    
    // 플로이드-워셜 알고리즘 구현
    static void floydWarshall() {
        // k: 경유 정점
        for (int k = 1; k <= V; k++) {
            // i: 출발 정점
            for (int i = 1; i <= V; i++) {
                // j: 도착 정점
                for (int j = 1; j <= V; j++) {
                    // i에서 k로 가는 경로와 k에서 j로 가는 경로가 모두 존재하는 경우
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        // i->j로 직접 가는 경로와 i->k->j로 가는 경로 중 더 짧은 것 선택
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
    
    // 최소 사이클의 길이를 찾는 메서드
    static int findMinimumCycle() {
        // 최소 사이클의 길이를 저장할 변수
        int minCycle = INF;
        
        // 모든 정점 쌍에 대해 검사
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                // i와 j가 서로 다르고, i->j와 j->i 경로가 모두 존재하는 경우
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    // i->j->i 경로의 길이와 현재까지의 최소 사이클 길이를 비교하여 갱신
                    minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
                }
            }
        }
        
        // 사이클이 존재하지 않으면 -1, 존재하면 최소 사이클의 길이 반환
        return minCycle == INF ? -1 : minCycle;
    }
}