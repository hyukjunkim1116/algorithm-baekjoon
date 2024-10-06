import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arrayList = new int[N];

        for (int i = 0; i < N; i++) {
            arrayList[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arrayList);

        for (int i = 0; i < N; i++) {
            System.out.println(arrayList[i]);
        }
    }

    static void bubbleSort(int[] arr) {
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}