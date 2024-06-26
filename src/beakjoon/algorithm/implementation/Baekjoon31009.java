package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon31009 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String destinateion = st.nextToken();
      int price = Integer.parseInt(st.nextToken());

      map.put(destinateion, price);
    }

    int jinju = map.get("jinju");
    System.out.println(jinju);

    int count = 0;
    for (String s : map.keySet()) {
      if (map.get(s) > jinju) count++;
    }

    System.out.println(count);
  }
}
