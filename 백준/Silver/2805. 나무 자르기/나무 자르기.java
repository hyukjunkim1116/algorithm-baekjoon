import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] forest = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        
        for(int i = 0; i < N; i++) {
            forest[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, forest[i]);
        }
        
        long s = 0;
        long e = maxHeight;
        
        while(s <= e) {
            long mid = (s + e) / 2;
            long wood = 0;
            
            for(int tree : forest) {
                if(tree > mid) {
                    wood += tree - mid;
                }
            }
            
            if(wood >= M) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        System.out.println(e);
    }
}
