package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon28289 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(br.readLine());    // 동아리 학생 수

    int soft = 0;
    int embedded = 0;
    int ai = 0;
    int none = 0;
    StringTokenizer st;
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());

      int g = Integer.parseInt(st.nextToken());     // 학년
      int c = Integer.parseInt(st.nextToken());     // 반
      int n = Integer.parseInt(st.nextToken());     // 번호

      if (g == 1) {
        none++;
        continue;
      }

      if (c == 1 || c == 2) soft++;
      else if (c == 3) embedded++;
      else ai++;
    }

    System.out.println(soft);
    System.out.println(embedded);
    System.out.println(ai);
    System.out.println(none);
  }
}
