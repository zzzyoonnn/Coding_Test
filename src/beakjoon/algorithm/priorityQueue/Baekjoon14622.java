package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14622 {
  static boolean turn;
  static long dwScore, gsScore;
  static HashSet<Integer> decimalSet;
  static PriorityQueue<Integer> dwDecimal;
  static PriorityQueue<Integer> gsDecimal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 라운드 수

    dwScore = 0;
    gsScore = 0;

    decimalSet = new HashSet<>();
    dwDecimal = new PriorityQueue<>(Comparator.reverseOrder());
    gsDecimal = new PriorityQueue<>(Comparator.reverseOrder());

    StringTokenizer st;
    for (int fight = 0; fight < N; fight++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      // 항상 대웅이부터 시작
      // turn
      turn = false;
      checkDecimal(d, dwDecimal);
      turn = true;
      checkDecimal(g, gsDecimal);
    }

    if (dwScore > gsScore) System.out.print("소수의 신 갓대웅");
    else if (dwScore == gsScore) System.out.print("우열을 가릴 수 없음");
    else System.out.print("소수 마스터 갓규성");

  }

  private static void isNotDecimal() {
    if (!turn) {
      if (gsDecimal.size() > 3) {
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
          if (i == 3) {
            gsScore += gsDecimal.poll();
          } else {
            temp.add(gsDecimal.poll());
          }
        }
      } else {
        gsScore += 1000;
      }
    } else {
      {
        if (dwDecimal.size() > 3) {
          Queue<Integer> temp = new LinkedList<>();
          for (int i = 1; i <= 3; i++) {
            if (i == 3) {
              dwScore += dwDecimal.poll();
            } else {
              temp.add(dwDecimal.poll());
            }
          }
        } else {
          dwScore += 1000;
        }
      }
    }
  }

  private static void checkDecimal(int num, PriorityQueue<Integer> pq) {


    if (num <= 1) {   // 소수 아님
      return;
    }

    for (int i = 2; i <= Math.sqrt(num); i++) {

      if (num % i == 0) {
        isNotDecimal();
      }
    }

    if (decimalSet.contains(num)) {
      if (!turn) dwScore -= 1000;
      else gsScore -= 1000;

    } else {
      decimalSet.add(num);
      pq.offer(num);
    }
  }
}
