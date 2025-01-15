
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N+1][N+1];

        int[] arrX = new int[N+1];
        int[] arrY = new int[N+1];


        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] tmp = new int[2];
                tmp[0] = x;
                tmp[1] = y;
                arr[i] = tmp;
                arrX[i] = x;
                arrY[i] = y;

                if (maxX < x) maxX = x;
                if (maxY < y) maxY = y;
                if (minX > x) minX = x;
                if (minY > y) minY = y;
        }
        int diffX = maxX - minX;
        int diffY = maxY - minY;
        arrX[arrX.length-1] = arrX[0];
        arrY[arrY.length-1] = arrY[0];
        System.out.println(Math.max(getMax(N,arrY,minY,diffY),getMax(N,arrX,minX,diffX)));
    }
    private static int getMax(int count,int[] array, int minimum, int difference) {
        int[] graph = new int[difference+1];
        for(int i = 0; i < count; i++) {
            if (array[i] != array[i+1] ) {
                int low = Math.min(array[i], array[i+1]) - minimum;
                int high = Math.max(array[i], array[i+1]) - minimum;
                graph[low] += 1;
                if (high < difference +1) {
                    graph[high] -= 1;
                }
            }
        }

        int[] prefix = new int[difference+1];
        for(int i = 0; i < prefix.length; i++) {
            if (i == 0) prefix[i] = graph[0];
            else prefix[i] = 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < difference+1; i++) {
            prefix[i] = prefix[i-1] + graph[i];
            if (prefix[i] > max) max = prefix[i];
        }
        return max;
    }
}