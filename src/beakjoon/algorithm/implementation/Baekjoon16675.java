package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String ml = st.nextToken();
    String mr = st.nextToken();
    String tl = st.nextToken();
    String tr = st.nextToken();

    StringBuilder sb = new StringBuilder();
    if (ml.equals(mr)) {
      if (ml.equals("S")) {
        if (tl.equals("R") || tr.equals("R")) sb.append("TK");
      } else if (ml.equals("R")) {
        if (tl.equals("P") || tr.equals("P")) sb.append("TK");
      } else if (ml.equals("P")) {
        if (tl.equals("S") || tr.equals("S")) sb.append("TK");
      } else {
        sb.append("MS");
      }
    }

    if (tl.equals(tr)) {
      if (tl.equals("S")) {
        if (ml.equals("R") || mr.equals("R")) sb.append("MS");
      } else if (tl.equals("R")) {
        if (ml.equals("P") || mr.equals("P")) sb.append("MS");
      } else if (tl.equals("P")) {
        if (ml.equals("S") || mr.equals("S")) sb.append("MS");
      } else {
        sb.append("TK");
      }
    }

    if (sb.isEmpty()) sb.append("?");

    System.out.println(sb.toString());
  }
}
