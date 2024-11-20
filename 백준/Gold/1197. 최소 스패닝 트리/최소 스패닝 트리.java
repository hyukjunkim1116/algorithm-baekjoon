import java.io.*;
import java.util.*;

public class Main {
    // 간선 클래스: 두 정점과 가중치 정보를 저장
    static class Edge implements Comparable<Edge> {
        int start;      // 시작 정점
        int end;        // 도착 정점
        int weight;     // 가중치
        
        // 생성자
        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        // 가중치를 기준으로 간선을 오름차순 정렬하기 위한 비교 메서드
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    // 부모 노드를 저장할 배열
    static int[] parent;
    // 간선들을 저장할 리스트
    static ArrayList<Edge> edgeList;
    
    // Find 연산: 해당 정점이 속한 집합의 대표 정점을 찾음
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 경로 압축을 위해 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }
    
    // Union 연산: 두 정점이 속한 집합을 합침
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 정점의 개수 V와 간선의 개수 E 입력
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 부모 배열 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;  // 초기에는 자기 자신이 부모
        }
        
        // 간선 리스트 초기화
        edgeList = new ArrayList<>();
        
        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(start, end, weight));
        }
        
        // 간선들을 가중치 기준으로 오름차순 정렬
        Collections.sort(edgeList);
        
        // 최소 신장 트리의 총 가중치
        long totalWeight = 0;
        // 선택된 간선의 개수
        int count = 0;
        
        // 크루스칼 알고리즘 수행
        for (Edge edge : edgeList) {
            // 두 정점이 서로 다른 집합에 속해 있다면
            if (find(edge.start) != find(edge.end)) {
                // 두 정점을 연결
                union(edge.start, edge.end);
                // 가중치를 더함
                totalWeight += edge.weight;
                // 선택된 간선 개수 증가
                count++;
            }
            
            // 최소 신장 트리가 완성되면 종료 (간선 개수 = 정점 개수 - 1)
            if (count == V - 1) {
                break;
            }
        }
        
        // 결과 출력
        System.out.println(totalWeight);
    }
}