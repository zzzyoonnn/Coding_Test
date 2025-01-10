package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon26596 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String vodka = st.nextToken();
      int amount = Integer.parseInt(st.nextToken());

      map.put(vodka, map.getOrDefault(vodka, 0) + amount);
    }

    ArrayList<Integer> list = new ArrayList();
    for (String key : map.keySet()) {
      list.add(map.get(key));
    }

    for (int i = 0; i < list.size() - 1; i++) {
      for (int j = i + 1; j < list.size(); j++) {
        int max = Math.max(list.get(i), list.get(j));
        int min = Math.min(list.get(i), list.get(j));


        if (Math.floor(min * (1.618)) == max) {
          System.out.print("Delicious!");
          System.exit(0);
        }
      }
    }
    System.out.print("Not Delicious...");
  }
}
