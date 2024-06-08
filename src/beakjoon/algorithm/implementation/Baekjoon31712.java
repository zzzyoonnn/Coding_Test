package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon31712 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int start = 0;
    int cycle, damage;
    HashMap<Integer, Integer> map = new HashMap<>();

    // 윤이
    st = new StringTokenizer(br.readLine());
    cycle = Integer.parseInt(st.nextToken());
    damage = Integer.parseInt(st.nextToken());
    map.put(cycle, damage);
    start += damage;

    // 달구
    st = new StringTokenizer(br.readLine());
    cycle = Integer.parseInt(st.nextToken());
    damage = Integer.parseInt(st.nextToken());
    map.put(cycle, map.getOrDefault(cycle, 0) + damage);
    start += damage;

    // 포닉스
    st = new StringTokenizer(br.readLine());
    cycle = Integer.parseInt(st.nextToken());
    damage = Integer.parseInt(st.nextToken());
    map.put(cycle, map.getOrDefault(cycle, 0) + damage);
    start += damage;

    int h = Integer.parseInt(br.readLine());

    int time = 0;
    h -= start;

    while (h > 0) {
      time++;

      for (int i : map.keySet()) {
        if (time % i == 0) {
          h -= map.get(i);
        }
      }
    }

    System.out.println(time);
  }
}
