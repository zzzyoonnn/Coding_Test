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
    int m = Integer.parseInt(st.nextToken());   // number of table

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
          Collections.sort(list, new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
              if (o1.time == o2.time) {
                return Integer.compare(o2.number, o1.number);   // Sort by time descending
              } else {
                return Integer.compare(o1.time, o2.time);       // Sort by time ascending
              }
            }
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