package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon13118 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashMap<Integer, Integer> position = new HashMap<>();


    for (int i = 1; i <= 4; i++) {
      int num = Integer.parseInt(st.nextToken());
      position.put(num, i);
    }

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());

    if (position.containsKey(x)) System.out.println(position.get(x));
    else System.out.println(0);
  }
}
