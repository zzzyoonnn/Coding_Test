package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18311 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 코스의 개수
    long k = Long.parseLong(st.nextToken());        // 이동 거리

    int[] course = new int[n];
    st = new StringTokenizer(br.readLine());

    long length = 0;       // 이동한 거리

    // 반환 전
    for (int i = 0; i < n; i++) {
      course[i] = Integer.parseInt(st.nextToken());
      k -= course[i];

      if (k < 0) {
        System.out.println(i + 1);
        System.exit(0);
      }
    }

    // 반환 후
    for (int i = n - 1; i >= 0; i--) {
      k -= course[i];

      if (k < 0) {
        System.out.println(i + 1);
        System.exit(0);
      }
    }
  }
}
