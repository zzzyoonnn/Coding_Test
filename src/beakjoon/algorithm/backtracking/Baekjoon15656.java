package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15656 {
  static int n, m;
  static int[] arr, printArr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    printArr = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    Arrays.sort(arr);

    backTracking(0, 0);

    System.out.print(sb.toString());
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(printArr[i]).append(" ");
      }
      sb.append('\n');
      return;
    }

    for (int i = 0; i < n; i++) {
      printArr[index] = arr[i];
      backTracking(index + 1, depth + 1);
    }
  }
}
