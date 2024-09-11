package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14612 {
  static ArrayList<Question> list = new ArrayList<>();
  static StringBuilder sb;
  static class Question {
    int number;
    int time;

    Question(int number, int time) {
      this.number = number;
      this.time = time;
    }

    public void toStringBuilder(StringBuilder sb) {
      sb.append(number).append(" ");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // number of question
    // int m = Integer.parseInt(st.nextToken());   // number of table

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String order = st.nextToken();

      switch (order) {
        case "order":
          int number1 = Integer.parseInt(st.nextToken());
          int time1 = Integer.parseInt(st.nextToken());

          list.add(new Question(number1, time1));

          printList();
          break;
        case "sort":
          list.sort((o1, o2) -> {
            int result = Integer.compare(o1.time, o2.time);
            if (result == 0) {
              result = Integer.compare(o1.number, o2.number);
            }
            return result;
          });
          printList();

          break;
        case "complete":
          int number2 = Integer.parseInt(st.nextToken());

          list.removeIf(q -> q.number == number2);
          printList();

          break;
      }
    }
  }

  static void printList() {
    sb = new StringBuilder();

    if (list.isEmpty()) {
      System.out.println("sleep");
    } else {
      for (Question q : list) {
        q.toStringBuilder(sb);
      }

      System.out.println(sb.toString());
    }
  }
}