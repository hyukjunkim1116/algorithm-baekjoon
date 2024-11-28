import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    // 희소 배열: parent[i][j]는 i번 노드의 2^j번째 조상
    static int[][] parent;
    static boolean[] visited;
    static int maxDepth; // 트리의 최대 깊이
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        // 최대 깊이 계산 (log2(N))
        maxDepth = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
        
        // 배열 초기화
        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        depth = new int[N + 1];
        parent = new int[N + 1][maxDepth];
        visited = new boolean[N + 1];
        
        // 트리 구성
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        // DFS로 깊이와 첫 번째 부모 계산
        dfs(1, 0);
        
        // 희소 배열 구성
        fillParent(N);
        
        // 쿼리 처리
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(lca(a, b)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    // DFS로 깊이와 직계 부모 계산
    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;
        
        for(int next : tree[current]) {
            if(!visited[next]) {
                parent[next][0] = current; // 직계 부모 저장
                dfs(next, d + 1);
            }
        }
    }
    
    // 희소 배열 구성
    static void fillParent(int N) {
        for(int j = 1; j < maxDepth; j++) {
            for(int i = 1; i <= N; i++) {
                // i의 2^j번째 부모 = i의 2^(j-1)번째 부모의 2^(j-1)번째 부모
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }
    }
    
    // LCA 찾기
    static int lca(int a, int b) {
        // b가 더 깊도록 설정
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        // 깊이 차이만큼 b를 올림
        for(int i = maxDepth-1; i >= 0; i--) {
            if(depth[b] - depth[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }
        
        // 동일한 노드인 경우
        if(a == b) return a;
        
        // 최소 공통 조상 찾기
        for(int i = maxDepth-1; i >= 0; i--) {
            if(parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        
        return parent[a][0];
    }
}