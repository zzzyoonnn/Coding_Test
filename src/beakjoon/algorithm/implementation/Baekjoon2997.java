package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2997 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[3];
    for (int i = 0; i < 3; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int gap1 = arr[1] - arr[0];
    int gap2 = arr[2] - arr[1];
    if (gap1 == gap2) System.out.print(arr[2] + gap1);
    else {
      if (gap1 > gap2) {
        System.out.print(arr[1] - gap2);
      } else {
        System.out.print(arr[2] - gap1);
      }
    }
  }
}
