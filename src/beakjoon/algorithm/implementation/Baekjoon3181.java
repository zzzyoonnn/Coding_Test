package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon3181 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    String word = st.nextToken().toUpperCase();
    sb.append(word.charAt(0));

    while (st.hasMoreTokens()) {
      word = st.nextToken();

      if (set.contains(word)) continue;

      word = word.toUpperCase();
      sb.append(word.charAt(0));

    }

    System.out.println(sb);
  }
}
