package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon26042 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<Integer>();

    int maxSize = -1;
    int lastStudent = Integer.MAX_VALUE;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        int studentNum = Integer.parseInt(st.nextToken());
        queue.add(studentNum);
        if (queue.size() > maxSize) {
          maxSize = queue.size();
          lastStudent = studentNum;
        } else if (queue.size() == maxSize) {
          lastStudent = Math.min(lastStudent, studentNum);
        }
      } else if (type == 2) {
        queue.poll();
      }
    }

    System.out.print(maxSize + " " + lastStudent);
  }
}
