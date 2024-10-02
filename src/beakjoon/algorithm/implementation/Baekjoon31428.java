package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon31428 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    String[] arr = br.readLine().split(" ");

    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    String helloBit = br.readLine();
    System.out.println(map.getOrDefault(helloBit, 0));
  }
}
