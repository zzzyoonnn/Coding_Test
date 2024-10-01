package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15649 {
  static int n, m;
  static int[] arr;
  static boolean[] checked;
  static int[] printArr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n + 1];
    printArr = new int[n];
    checked = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = i;
    }

    checked[0] = true;
    backTracking(0, 0);

    System.out.print(sb.toString());
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(printArr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }


    for (int i = 1; i <= n; i++) {
      if (!checked[i]) {
        checked[i] = true;
        printArr[depth] = arr[i];
        backTracking(i + 1, depth + 1);
        checked[i] = false;
      }
    }
  }
}
