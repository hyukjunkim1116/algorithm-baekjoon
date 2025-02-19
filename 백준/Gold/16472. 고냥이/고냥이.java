import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] arr = input.toCharArray();
        
        int s = 0;
        int e = 0;
        ArrayList<Character> letters = new ArrayList<>();
        letters.add(arr[s]);
        
        int dist = 0;
        
        while(s < arr.length && e < arr.length) {
            dist = Math.max(dist, e - s + 1);
            
            if(letters.size() <= n) {
                e++;
                if(e < arr.length && !letters.contains(arr[e])) {
                    letters.add(arr[e]);
                }
            }
            
            if(letters.size() > n) {
                s = s + 1;
                e = s;
                letters.clear();
                letters.add(arr[s]);
            }
        }
        
        System.out.println(dist);
    }
}
