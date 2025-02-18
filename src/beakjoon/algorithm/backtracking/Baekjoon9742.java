package beakjoon.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9742 {
  static int target, count;
  static char[] chars;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String s;
    StringBuilder sb = new StringBuilder();
    while ((s = br.readLine()) != null && !s.isEmpty()) {
      st = new StringTokenizer(s);
      String str = st.nextToken();
      chars = str.toCharArray();
      visited = new boolean[chars.length];
      target = Integer.parseInt(st.nextToken());

      count = 0;
      sb.append(str).append(" ").append(target).append(" = ").append(backTracking(new StringBuilder(), 0)).append('\n');
    }
    System.out.print(sb);
  }

  private static String backTracking(StringBuilder current, int now) {
    if ((current.length() == chars.length)) {
      count++;

      if (target == count) {
        return current.toString();
      }
    }

    for (int i = 0; i < chars.length; i++) {
      if (visited[i]) continue;

      visited[i] = true;
      current.append(chars[i]);
      String result = backTracking(current, now + 1);

      if (!result.equals("No permutation")) {
        return result;
      }

      current.deleteCharAt(current.length() - 1);
      visited[i] = false;
    }
    return "No permutation";
  }
}
