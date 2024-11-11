import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 학생 수, M: 키 비교 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 진입차수 배열 초기화
        inDegree = new int[N + 1];
        
        // 키 비교 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);     // A가 B앞에 서야 함
            inDegree[B]++;           // B의 진입차수 증가
        }
        
        // 위상정렬 수행
        topologicalSort();
    }
    
    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        // 진입차수가 0인 학생을 큐에 삽입
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");
            
            // 현재 학생과 연결된 다음 학생들의 진입차수 감소
            for(int next : graph.get(current)) {
                inDegree[next]--;
                // 진입차수가 0이 되면 큐에 삽입
                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        System.out.println(sb);
    }
}