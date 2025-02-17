package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9742 {
  static int count;
  static char[] chars;
  static boolean[] visited;
  static StringBuilder st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String s;
    while ((s = br.readLine()) != null && !s.isEmpty()) {
      st = new StringTokenizer(s);
      String str = st.nextToken();
      chars = str.toCharArray();
      count = Integer.parseInt(st.nextToken());

      System.out.println(backTracking(new StringBuilder(), 0));
    }
  }

  private static String backTracking(StringBuilder current, int now) {
    if (count == now) {
      String result = new String(chars);
      return result;
    }

    for (int i = 0; i < chars.length; i++) {
      if (visited[i]) continue;

      visited[i] = true;
      current.append(chars[i]);

      backTracking(current, now + 1);

      current.deleteCharAt(current.length() - 1);
      visited[i] = false;
    }

    return "No permutation";
  }
}
