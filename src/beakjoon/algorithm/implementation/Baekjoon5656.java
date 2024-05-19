package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5656 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int a, b;
    String oper, result;

    int temp = 1;
    StringBuilder sb = new StringBuilder();
    while (true) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      oper = st.nextToken();
      b = Integer.parseInt(st.nextToken());

      if (oper.equals("E")) break;

      if (oper.equals(">")) sb.append("Case ").append(temp).append(": ").append(a > b).append('\n');
      else if (oper.equals(">=")) sb.append("Case ").append(temp).append(": ").append(a >= b).append('\n');
      else if (oper.equals("<")) sb.append("Case ").append(temp).append(": ").append(a < b).append('\n');
      else if (oper.equals("<=")) sb.append("Case ").append(temp).append(": ").append(a <= b).append('\n');
      else if (oper.equals("==")) sb.append("Case ").append(temp).append(": ").append(a == b).append('\n');
      else if (oper.equals("!=")) sb.append("Case ").append(temp).append(": ").append(a != b).append('\n');

      temp++;
    }
    System.out.println(sb);
  }
}
