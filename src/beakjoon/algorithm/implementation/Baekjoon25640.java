package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon25640 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String jinho = br.readLine();
    HashMap<String, Integer> map = new HashMap<>();
    map.put(jinho, 0);

    String s;
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      s = br.readLine();

      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      }
    }

    System.out.print(map.get(jinho));
  }
}
