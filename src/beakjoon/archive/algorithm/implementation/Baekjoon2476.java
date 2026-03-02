package beakjoon.archive.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2476 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int max = -1;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      max = Math.max(max, calculate(a, b, c));
    }
      System.out.print(max);
  }

  private static int calculate(int a, int b, int c) {

    // 세개 같음
    if (a == b && a == c) return (a * 1_000) + 10_000;

    // 두 개 같음
    else if (a == b || a == c) return (a * 100) + +1_000;
    else if (b == c) return (b * 100) + +1_000;

    // 모두 다름
    return Math.max(Math.max(a, b), c) * 100;
  }
}
