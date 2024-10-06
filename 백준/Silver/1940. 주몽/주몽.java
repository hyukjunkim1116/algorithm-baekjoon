import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //6
    //9
    //2 7 4 1 5 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int count = 0;
        while (startIndex < endIndex) {

            int sum = arr[startIndex] + arr[endIndex];

            if (sum == M) {
                count++;
                startIndex++;
                endIndex--;
            } else if (sum < M) {
                startIndex++;
            } else {
                endIndex --;
            }
        }
        System.out.println(count);
    }
}