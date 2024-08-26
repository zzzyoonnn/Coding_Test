package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1952 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int row = Integer.parseInt(st.nextToken());
    int column = Integer.parseInt(st.nextToken());


    int count = 1;
    //if (row < column) count--;
    boolean check = true;   // true -> max, false -> min
    while (true) {
      if (row == 1 || column == 1) break;

      if (check) {
        row--;
        check = false;
      } else {
        column--;
        check = true;
      }

      count++;
    }

    System.out.println(count);
  }
}
