package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baeckjoon25642 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());   // yongtae
    int b = Integer.parseInt(st.nextToken());   // yujin

    boolean check = true;   // true -> yt, false -> yj
    while (true) {
      if (check) b += a;
      else a += b;

      if (a >= 5 || b >= 5) break;

      check = !check;
    }

    if (check) System.out.println("yt");
    else System.out.println("yj");
  }
}
