package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon5464 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // 주차 공간들의 단위 무게당 요금
    int m = Integer.parseInt(st.nextToken());   // 차량들의 무게

    int[] parking = new int[n + 1];

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(0);
    for (int i = 1; i <= m; i++) list.add(Integer.parseInt(st.nextToken()));


  }
}
