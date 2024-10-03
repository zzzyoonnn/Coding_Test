package beakjoon.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15652 {
  static int n, m;
  static int[] arr, printArr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    printArr = new int[m];

    backTracking(0, 0);

    System.out.println(sb.toString());
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i : printArr) {
        sb.append(i).append(" ");
      }
      sb.append('\n');
      return;
    }

    for (int i = index; i < arr.length; i++) {
      printArr[depth] = arr[i];
      backTracking(i, depth + 1);
    }
  }
}
