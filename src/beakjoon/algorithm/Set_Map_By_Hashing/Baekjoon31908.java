package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon31908 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 왼손 약지를 확인할 사람의 수

    HashMap<String, String> nameMap = new HashMap<>();
    HashMap<String, Integer> ringMap = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      String ring = st.nextToken();

      if (ring.equals("-")) continue;

      nameMap.put(name, ring);
      ringMap.put(ring, ringMap.getOrDefault(ring, 0) + 1);
    }

    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (String s : ringMap.keySet()) {
      if (ringMap.get(s) == 2) {
        count++;
        for (String str : nameMap.keySet()) {
          if (nameMap.get(str).equals(s)) {
            sb.append(str).append(' ');
          }
        }

        sb.append('\n');
      }
    }

    System.out.println(count);
    System.out.println(sb);
  }
}
