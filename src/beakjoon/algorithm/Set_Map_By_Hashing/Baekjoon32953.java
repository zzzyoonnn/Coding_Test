package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon32953 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < num; j++) {
        String number = st.nextToken();

        map.put(number, map.getOrDefault(number, 0) + 1);
      }
    }

    int count = 0;
    for (String s : map.keySet()) {
      if (map.get(s) >= M) count++;
    }

    System.out.print(count);
  }
}
