package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon5766 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> list;
    StringTokenizer st;
    HashMap<Integer, Integer> map;
    StringBuilder sb = new StringBuilder();


    while (true) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      if (n == 0 && m == 0) break;

      list = new ArrayList<Integer>();
      map = new HashMap<>();

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          int player = Integer.parseInt(st.nextToken());

          map.put(player, map.getOrDefault(player, 0) + 1);
        }
      }

      // value 기준 최대값 찾기
      Integer maxValue = Collections.max(map.values());
      for (int i : map.keySet()) {
        if (map.get(i).equals(maxValue)) map.put(i, 0);
      }

      maxValue = Collections.max(map.values());

      for (int i : map.keySet()) {

        if (map.get(i).equals(maxValue)) {
          list.add(i);
        }
      }

      Collections.sort(list);

      for (int i = 0; i < list.size(); i++) {
        sb.append(list.get(i)).append(' ');
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}
