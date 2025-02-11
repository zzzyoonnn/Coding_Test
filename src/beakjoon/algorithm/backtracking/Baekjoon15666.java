package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon15666 {
  static int n, m;
  static String s;
  static int[] arr, printArr;
  static StringBuilder sb = new StringBuilder();
  static ArrayList<String> list = new ArrayList<>();

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
    Arrays.sort(arr);

    printArr = new int[m];

    backTracking(0, 0);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  private static void backTracking(int index, int depth) {
    if (depth == m) {
      for (int i : printArr) {
        sb.append(i).append(" ");
      }
      s = sb.toString();
      if (!list.contains(s)) list.add(s);
      sb = new StringBuilder();
      return;
    }

    for (int i = index; i < arr.length; i++) {
      printArr[depth] = arr[i];
      backTracking(i, depth + 1);
    }
  }
}
