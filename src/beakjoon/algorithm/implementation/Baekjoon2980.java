package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2980 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 신호등의 개수
    int l = Integer.parseInt(st.nextToken());       // 도로의 길이

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());     // 신호등의 위치
      int r = Integer.parseInt(st.nextToken());     // 빨간 신호가 지속되는 시간
      int g = Integer.parseInt(st.nextToken());     // 초록 신호가 지속되는 시간
    }
  }
}
