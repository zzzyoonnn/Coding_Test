package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 과일장수 {
  public static int solution(int k, int m, int[] score) {
    int answer = 0;

    Arrays.sort(score);

    int min = k;
    int count = 0;
    for (int i = score.length - 1; i >= 0; i--) {
      count++;

      min = Math.min(score[i], min);

      if (count == m) {
        answer += (min * m);
        count = 0;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
//    int k = 3;
//    int m = 4;
//    int[] score = {1, 2, 3, 1, 2, 3, 1};

    int k = 4;
    int m = 3;
    int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

    System.out.println(solution(k, m, score));
  }
}
