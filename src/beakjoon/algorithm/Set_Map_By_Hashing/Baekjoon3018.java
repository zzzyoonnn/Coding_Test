package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon3018 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int days = Integer.parseInt(br.readLine());

    StringTokenizer st;
    HashMap<Integer, TreeSet<String>> map = new HashMap<>();
    int count = 1;
    TreeSet<String> set;
    for (int day = 0; day < days; day++) {
      st = new StringTokenizer(br.readLine());
      int listSize = Integer.parseInt(st.nextToken());
      set = new TreeSet<>();
      for (int index = 0; index < listSize; index++) {
        set.add(st.nextToken());
      }

      if (set.contains("1")) map.put(count++, set);
      else {
        for (String s : set) {
          for (Set<String> value : map.values()) {
            if (value.contains(s)) value.addAll(set);
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      int cnt = 0;
      for (Set<String> value : map.values())
        if (value.contains(String.valueOf(i))) cnt++;

      if (cnt == map.size()) System.out.println(i);
    }
  }
}
