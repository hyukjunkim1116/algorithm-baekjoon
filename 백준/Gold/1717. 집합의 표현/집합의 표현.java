import java.io.*;
import java.util.*;

public class Main {
    static int[] par;
    static int[] rank;
    
    static int find(int a) {
        if (par[a] == a) {
            return a;
        }
        return par[a] = find(par[a]);  // Path compression
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return;
        
        if (rank[a] < rank[b]) {
            par[a] = b;
        } else if (rank[a] > rank[b]) {
            par[b] = a;
        } else {
            par[b] = a;
            rank[a]++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        par = new int[N + 1];
        rank = new int[N + 1];
        
        // Initialize parent array
        for (int i = 0; i <= N; i++) {
            par[i] = i;
        }
        
        // Process queries
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if (X == 0) {
                union(A, B);
            } else {
                sb.append(find(A) == find(B) ? "YES\n" : "NO\n");
            }
        }
        
        System.out.print(sb);
    }
}
