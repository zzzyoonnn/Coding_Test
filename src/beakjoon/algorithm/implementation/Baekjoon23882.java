package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon23882 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   // 배열의 크기
        int k = Integer.parseInt(st.nextToken());   // 교환 횟수

        int[] arr = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = a - 1; i > 0; i--) {
            int last = i;
            int max = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (arr[max] != arr[last]) {
                int temp = arr[max];
                arr[max] = arr[last];
                arr[last] = temp;
                count++;
            }

            if (count == k) {
                for (int idx = 0; idx < a; idx++) {
                    System.out.print(arr[idx] + " ");
                }
                System.exit(0);
            }
        }
        if (count < k) System.out.println(-1);
    }
}
