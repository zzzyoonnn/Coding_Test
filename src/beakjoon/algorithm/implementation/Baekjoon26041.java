package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon26041 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    while (st.hasMoreTokens()) {
      list.add(st.nextToken());
    }

    String number = br.readLine();

    int count = 0;
    for (String s : list) {
      if (s.startsWith(number) && !s.equals(number)) count++;
    }

    System.out.println(count);
  }
}
