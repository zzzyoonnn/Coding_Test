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

    int currentIndex = 0;       // 리스트의 첫 번째 요소부터 제거하기 위해 인덱스를 0으로 초기화
    for(long i = 1; i < n; i++) {
      currentIndex = (int)(((currentIndex + Math.pow(i, 3)) - 1) % list.size());
      // currentIndex + Math.pow(i, 3)) - 1 : 리스트에서 제거할 요소의 위치
      // % list.size() : 리스트를 순환하며 인덱스를 조정하기 위해
      list.remove(currentIndex);
    }
    System.out.println(list.get(0));
  }
}
