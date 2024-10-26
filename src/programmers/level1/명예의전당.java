package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 명예의전당 {
  public static int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < score.length; i++) {
      if (i == k) break;
      list.add(score[i]);
      Collections.sort(list);
      answer[i] = list.get(0);
    }

    for (int i = k; i < answer.length; i++) {
      System.out.println(list);
      if (list.get(0) < score[i]) {
        list.remove(0);
        list.add(score[i]);
        Collections.sort(list);
      }

      answer[i] = list.get(0);
    }

    return answer;
  }

  public static void main(String[] args) {
//    int k = 3;
//    int[] score = {10, 100, 20, 150, 1, 100, 200};

    int k = 4;
    int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

    System.out.println(Arrays.toString(solution(k, score)));
  }
}
