package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon18429 {
  static int n, k, count = 0, total = 0;
  static int[] arr, printArr;
  static boolean[] check;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    check = new boolean[n];
    printArr = new int[n];

    backTracking(0, 0);
    //System.out.print(sb.toString());

    System.out.println(count);
  }

  private static void backTracking(int index, int depth) {
    if (depth == n) {
      for (int i : printArr) {
        sb.append(i).append(' ');
      }
      sb.append('\n');
      count++;
      return;
    }


    for (int i = 0; i < arr.length; i++) {
      if (!check[i]) {
        if (total + arr[i] >= k) {
          total += arr[i] - k;
          check[i] = true;
          printArr[depth] = arr[i];
          backTracking(0, depth + 1);
          check[i] = false;
          total -= arr[i] - k;
        }
      }
    }
  }
}
