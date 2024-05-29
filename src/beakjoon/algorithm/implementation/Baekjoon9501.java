package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());             // 우주선의 개수
      double d = Double.parseDouble(st.nextToken());        // 목적지까지의 거리

      int count = 0;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        double v = Double.parseDouble(st.nextToken());      // 우주선의 최고 속도
        double f = Double.parseDouble(st.nextToken());      // 우주선의 연료 양
        double c = Double.parseDouble(st.nextToken());      // 우주선의 연료 소비율

        // 거 속 시 공식 사용
        if ((d / v) * c <= f) count++;
      }

      System.out.println(count);
    }
  }
}
