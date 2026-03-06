package beakjoon.step_by_step.stage_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2908 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String s1 = st.nextToken();
    String s2 = st.nextToken();

    StringBuilder sb1, sb2;
    sb1 = new StringBuilder(s1).reverse();
    sb2 = new StringBuilder(s2).reverse();
    int a = Integer.parseInt(sb1.toString());
    int b = Integer.parseInt(sb2.toString());

    System.out.print(a > b ? a : b);
  }
}
