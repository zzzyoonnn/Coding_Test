package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon9933 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String pw;
    StringBuilder sb;
    HashSet<String> set = new HashSet<String>();
    for (int i = 0; i < N; i++) {
      pw = br.readLine();
      sb = new StringBuilder(pw);

      sb.reverse();

      if (set.contains(pw) || pw.equals(sb.toString())) {
        System.out.print(pw.length() + " " + pw.charAt(pw.length() / 2));
        System.exit(0);
      }

      set.add(sb.toString());
    }


  }
}
