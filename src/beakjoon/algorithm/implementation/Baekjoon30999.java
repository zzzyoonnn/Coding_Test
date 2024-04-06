package beakjoon.algorithm.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon30999 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());       // 문제 후보의 수
    int m = Integer.parseInt(st.nextToken());       // 출제의원의 수

    int result = 0;
    for (int i = 0; i < n; i++) {
      String s = br.readLine();

      int count = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'O') count++;
      }

      if (count > m / 2) result++;
    }

    System.out.println(result);
  }
}
