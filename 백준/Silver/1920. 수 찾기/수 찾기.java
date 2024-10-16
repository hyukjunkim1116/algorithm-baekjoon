
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(arr,Integer.parseInt(st.nextToken())));
        }
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (target == arr[mid]) {
                return 1;
            } else if (arr[mid] < target) {
                start = mid +1;

            } else if (target < arr[mid]) {
                end = mid -1 ;
            }
        }
        return 0;
    }
}