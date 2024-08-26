package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[101];
        int[] arr2 = new int[101];

        int prev = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = prev + 1; j <= length + prev; j++) {
                arr1[j] = speed;

                System.out.println(j + " " + arr2[j]);
            }

            prev += length;
        }

        prev = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = prev + 1; j <= length + prev; j++) {
                arr2[j] = speed;

                System.out.println(j + " " + arr2[j]);
            }

            prev += length;
        }

        int max = 0;
        for (int i = 0; i < 101; i++) {
            max = Math.max(max, arr2[i] - arr1[i]);
        }

        System.out.println(max);
    }
}
