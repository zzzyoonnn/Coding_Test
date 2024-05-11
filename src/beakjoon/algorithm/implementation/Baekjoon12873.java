package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon12873 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 참가자의 수

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) list.add(i);

    int currentIndex=0;
    for(long i = 1; i < n; i++) {
      currentIndex = (int)((currentIndex + i * i  * i - 1) % list.size());
      list.remove(currentIndex);
    }
    System.out.println(list.get(0));
  }
}
