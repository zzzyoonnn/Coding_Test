package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25377 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // number of store
    StringTokenizer st;

    int min = 1001;
    int minTime = 1001;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (b - a < 0) continue;

      minTime = Math.min(b, minTime);
    }

    if (minTime == 1001) minTime = -1;

    System.out.println(minTime);
  }
}
