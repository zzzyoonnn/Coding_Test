package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon24051 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

    int count = 0;
    for (int i = 1; i < arr.length; i++) {
      int now = arr[i];
      int j = i - 1;

      while (j >= 0 && now < arr[j]) {
        arr[j + 1] = arr[j];
        count++;

        if (count == k) {
          System.out.print(arr[j]);
          System.exit(0);
        }
        j--;
      }

      if (j + 1 != i) {
        arr[j + 1] = now;
        count++;

        if (count == k) {
          System.out.print(now);
          System.exit(0);
        }
      }
    }

    if (count - 1 < k) {
      System.out.print(-1);
    }
  }
}
