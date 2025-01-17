package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < T; tc++) {
      int k = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> minPq = new PriorityQueue<>();
      PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < k; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        if (command.equals("I")) {
          minPq.offer(n);
          maxPq.offer(n);
          map.put(n, map.getOrDefault(n, 0) + 1);
        } else {
          if (n == 1) {
            removeTop(maxPq, map);
          } else {
            removeTop(minPq, map);
          }
        }
      }

      removeInvalid(minPq, map);
      removeInvalid(maxPq, map);

      if (map.isEmpty()) {
        System.out.println("EMPTY");
      } else {
        int max = maxPq.peek();
        int min = minPq.peek();
        System.out.println(max + " " + min);
      }
    }
  }

  private static void removeTop(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
    removeInvalid(heap, map);
    if (!heap.isEmpty()) {
      int top = heap.poll();
      map.put(top, map.get(top) - 1);
      if (map.get(top) == 0) {
        map.remove(top);
      }
    }
  }

  private static void removeInvalid(PriorityQueue<Integer> heap, HashMap<Integer, Integer> map) {
    while (!heap.isEmpty() && map.getOrDefault(heap.peek(), 0) == 0) {
      heap.poll();
    }
  }
}
