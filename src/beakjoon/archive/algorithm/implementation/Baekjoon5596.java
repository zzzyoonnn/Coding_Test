package beakjoon.archive.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5596 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = 0;
    for (int i = 0; i < 4; i++) {
      S += Integer.parseInt(st.nextToken());
    }
    int T = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      T += Integer.parseInt(st.nextToken());
    }

    System.out.print(S >= T ? S : T);
  }
}
