package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2145 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sum = 0;
    String num;
    int n;
    while (true) {
      num = br.readLine();

      if (num.equals("0")) break;

      sum = 0;

      if (num.length() == 1) {
        sum = Integer.parseInt(num);
        System.out.println(sum);
      } else {
        for (int i = 0; i < num.length(); i++) {

        }
      }

        while (n > 0) {
          sum += n % 10;
          System.out.print(n % 10 + " ");
          n /= 10;
        }
        if (sum >= 10) n = sum;
      }
    }
  }
}
