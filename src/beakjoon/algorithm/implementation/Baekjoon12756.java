package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12756 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a1 = Integer.parseInt(st.nextToken());
    int a2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int b1 = Integer.parseInt(st.nextToken());
    int b2 = Integer.parseInt(st.nextToken());

    while (true) {
      a2 -= b1;
      b2 -= a1;

      if (a2 <= 0 || b2 <= 0) break;
    }

    if (a2 > 0) System.out.println("PLAYER A");
    else if (b2 > 0) System.out.println("PLAYER B");
    else System.out.println("DRAW");
  }
}
