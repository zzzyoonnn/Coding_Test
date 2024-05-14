package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon31628 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] arr = new String[10][10];

    StringTokenizer st;
    for (int i = 0; i < 10; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 10; j++) {
        arr[i][j] = st.nextToken();
      }
    }

    boolean check = false;

    for (int i = 0; i < 10; i++) {
      String word = arr[i][0];

      if (word.equals(arr[i][1]) && word.equals(arr[i][2]) && word.equals(arr[i][3]) && word.equals(arr[i][4]) && word.equals(arr[i][5]) &&
          word.equals(arr[i][6]) && word.equals(arr[i][7]) && word.equals(arr[i][8]) && word.equals(arr[i][9])) check = true;

      word = arr[0][i];
      if (word.equals(arr[1][i]) && word.equals(arr[2][i]) && word.equals(arr[3][i]) && word.equals(arr[4][i]) && word.equals(arr[5][i]) &&
          word.equals(arr[6][i]) && word.equals(arr[7][i]) && word.equals(arr[8][i]) && word.equals(arr[9][i])) check = true;
    }

    if (check) System.out.println(1);
    else System.out.println(0);
  }
}
