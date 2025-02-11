package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15654 {
  static int n, m;
  static int[] arr, printArr;
  static boolean[] check;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    check = new boolean[n];
    printArr = new int[m];

    Arrays.sort(arr);
    backTracking(0, 0);

    System.out.print(sb.toString());
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i : printArr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!check[i]) {
        printArr[index] = arr[i];
        check[i] = true;
        backTracking(index + 1, depth + 1);
        check[i] = false;
      }
    }
  }
}
