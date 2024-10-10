package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14719 {
  static int h, w;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());   // height
    w = Integer.parseInt(st.nextToken());   // width

    int[] arr = new int[w];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int water = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      int left = 0;
      int right = 0;

      for (int x = 0; x < i; x++) {
        left = Math.max(left, arr[x]);
      }

      for (int y = i + 1; y < arr.length; y++) {
        right = Math.max(right, arr[y]);
      }

      int standard = Math.min(left, right);
      if (standard <= arr[i]) continue;

      water += (standard - arr[i]);
    }

    System.out.print(water);
  }

}
