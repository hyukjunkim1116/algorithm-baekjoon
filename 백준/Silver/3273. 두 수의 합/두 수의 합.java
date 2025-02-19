import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int sum = Integer.parseInt(br.readLine());

        int s = 0;
        int e = n - 1;
        int answer = 0;

        while(s < e) {
            int currentSum = array[s] + array[e];

            if(currentSum > sum) {
                e--;
            }
            else if(currentSum == sum) {
                answer++;
                e--;
            }
            else {
                s++;
            }
        }

        System.out.println(answer);
    }
}