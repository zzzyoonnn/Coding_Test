package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon14402 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();

    int count = 0;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String check = st.nextToken();

      if (check.equals("+")) {          // check == "+"일 때
        map.put(name, map.getOrDefault(name, 0) + 1);
      }

      if (check.equals("-")) {          // check == "-"일 때
        if (!map.containsKey(name)) {
          count++;
        } else if (map.get(name) <= 0){
          count++;
        } else {
          map.replace(name, map.get(name) - 1);
        }
      }
    }

    for (String s : map.keySet()) {
      count+= map.get(s);
    }

    System.out.println(count);
  }
}