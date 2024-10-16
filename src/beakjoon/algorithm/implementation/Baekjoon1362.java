package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1362 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int o, w, standard, effect, index = 1;
    boolean death = false;
    String s, action;
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      o = Integer.parseInt(st.nextToken());   // proper weight
      w = Integer.parseInt(st.nextToken());   // actual weight

      if (o == 0 && w == 0) break;

      death = false;
      while (true) {
        st = new StringTokenizer(br.readLine());
        action = st.nextToken();
        effect = Integer.parseInt(st.nextToken());

        if (action.equals("#") && effect == 0) break;

        switch (action) {
          case "F":
            w += effect;
            break;
          case "E":
            w -= effect;
            if (w <= 0) death = true;
            break;
        }

      }
      if (death) System.out.println(index + " RIP");
      else if (w > (o / 2) && w < (o * 2)) System.out.println(index + " :-)");
      else System.out.println(index + " :-(");

      index++;

    }
  }
}
