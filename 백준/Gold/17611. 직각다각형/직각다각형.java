
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arrX = new int[N + 1];
        int[] arrY = new int[N + 1];

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrX[i] = x;
            arrY[i] = y;

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        arrX[N] = arrX[0];
        arrY[N] = arrY[0];

        int diffX = maxX - minX;
        int diffY = maxY - minY;

        int result = Math.max(
                getMax(N, arrX, minX, diffX),
                getMax(N, arrY, minY, diffY)
        );

        System.out.println(result);
    }

    private static int getMax(int N, int[] array, int minimum, int difference) {
        int[] graph = new int[difference + 1];

        for (int i = 0; i < N; i++) {
            int low = Math.min(array[i] - minimum, array[i + 1] - minimum);
            int high = Math.max(array[i] - minimum, array[i + 1] - minimum);

            if (array[i] != array[i + 1]) {
                graph[low]++;
                graph[high]--;
            }
        }

        int[] prefix = new int[difference + 1];
        for (int i = 0; i < graph.length; i++) {
            prefix[i] = (i == 0) ? graph[i] : prefix[i-1] + graph[i];
        }

        return java.util.Arrays.stream(prefix)
                .max()
                .orElse(0);
    }
}