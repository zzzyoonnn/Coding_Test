package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon17264 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of games
    int p = Integer.parseInt(st.nextToken());   // player

    st = new StringTokenizer(br.readLine());
    int w = Integer.parseInt(st.nextToken());   // when you win
    int l = Integer.parseInt(st.nextToken());   // when you lose
    int g = Integer.parseInt(st.nextToken());   // IRON's standard

    HashMap<String, Integer> map = new HashMap<>();

    String name;
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      name = st.nextToken();
      String status = st.nextToken();
      if (status.equals("W")) map.put(name, w);
      else map.put(name, -l);
    }

    int score = 0;
    boolean check = false;
    for (int i = 0; i < n; i++) {
      name = br.readLine();

      if (map.containsKey(name)) {
        score += map.get(name);
      } else {
        score -= l;
      }

      if (score < 0) score = 0;

      if (score >= g) {
        check = true;
        break;
      }
    }

    if (check) System.out.print("I AM NOT IRONMAN!!");
    else System.out.print("I AM IRONMAN!!");
  }
}
