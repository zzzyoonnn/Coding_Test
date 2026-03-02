package beakjoon.archive.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon19640 {
  private static class Employee implements Comparable<Employee> {
    int day;
    int toilet;
    boolean isDeka;
    int index;

    public Employee(int day, int toilet, boolean isDeka, int index) {
      this.day = day;
      this.toilet = toilet;
      this.isDeka = isDeka;
      this.index = index;
    }

    @Override
    public int compareTo(Employee other) {
      if (this.day != other.day) {
        return Integer.compare(other.day, this.day);
      }

      if (this.toilet != other.toilet) {
        return Integer.compare(other.toilet, this.toilet);
      }

      return Integer.compare(this.index, other.index);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Employee>[] q = new Queue[M];
    for (int i = 0; i < M; i++) {
      q[i] = new LinkedList<>();
    }


    for (int employee = 0; employee < N; employee++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      boolean isDeka = (employee == K);
      int index = employee % M;


      q[index].add(new Employee(d, h, isDeka, index));
    }

    int count = 0;

    while (true) {
      Employee maxEmployee = null;
      int maxIndex = -1;

      for (int i = 0; i < q.length; i++) {
        if (!q[i].isEmpty()) {
          Employee current = q[i].peek();

          if (current.isDeka) {
            System.out.print(count);
            return;
          }

          if (maxEmployee == null || current.compareTo(maxEmployee) > 0) {
            maxEmployee = current;
            maxIndex = i;
          }
        }
      }

      if (maxIndex != -1) {
        q[maxIndex].poll();
      }

      count++;
    }
  }
}
