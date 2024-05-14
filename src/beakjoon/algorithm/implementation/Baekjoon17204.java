package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon17204 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());       // 게임에 참여하는 사람의 수
    int k = Integer.parseInt(st.nextToken());       // 보성이의 번호

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {       // i번 사람이 지목하는 사람의 번호
      map.put(i, Integer.parseInt(br.readLine()));
    }

    int now = 0;
    int count = 0;
    while (now != k) {
      if (count > n) break;     // 보성이가 걸리지 않는다

      int forward = map.get(now);
      count++;

      now = forward;
    }

    if (count > n) System.out.println(-1);
    else System.out.println(count);
  }
}
