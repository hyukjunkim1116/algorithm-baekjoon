import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] relation;
    static int[] parent;
    static int n;
    
    static void dfs(int node, int prev) {
        for (int next : relation[node]) {
            if (next == prev) continue;
            
            parent[next] = node;
            dfs(next, node);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        relation = new ArrayList[n + 1];
        parent = new int[n + 1];
        
        // Initialize ArrayLists
        for (int i = 0; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }
        
        // Input edges
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a].add(b);
            relation[b].add(a);
        }
        
        dfs(1, 0);
        
        // Output results
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
}
