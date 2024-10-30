package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon32369 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[] onion = new int[2];
    Arrays.fill(onion, 1);

    for (int i = 0; i < n; i++) {
      onion[0] += a;
      onion[1] += b;

      if (onion[1] > onion[0]) {
        int temp = onion[0];
        onion[0] = onion[1];
        onion[1] = temp;
      } else if (onion[1] == onion[0]) {
        onion[1]--;
      }
    }

    System.out.print(onion[0] + " " + onion[1]);
  }
}
