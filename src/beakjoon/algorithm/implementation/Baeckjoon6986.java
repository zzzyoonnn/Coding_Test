package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baeckjoon6986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        double first = 0.0;
        double second = 0.0;

        for (int i = 0; i < k; i++) {
            second += arr[k];
            second += arr[n - k - 1];
        }

        for (int i = k; i < n - k; i++) {
            first += arr[i];
            second += arr[i];
        }

        System.out.println(String.format("%.2f", first / (n - (k * 2)) + 1e-9));
        System.out.println(String.format("%.2f", second / n + 1e-9));
    }
}
