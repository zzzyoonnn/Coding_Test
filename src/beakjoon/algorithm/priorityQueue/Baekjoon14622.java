package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14622 {
  static int round;
  static boolean[] check;
  static HashSet<Integer> decimalSet;
  static long[] score;
  static PriorityQueue<Integer>[] pq = new PriorityQueue[2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 라운드 수

    initialize();
    eratos();

    StringTokenizer st;
    for (round = 1; round <= N; round++) {
      st = new StringTokenizer(br.readLine());

      for (int turn = 0; turn < 2; turn++) {
        int num = Integer.parseInt(st.nextToken());

        checkDecimal(num, turn);
      }
    }

    if (score[0] > score[1]) System.out.print("소수의 신 갓대웅");
    else if (score[0] == score[1]) System.out.print("우열을 가릴 수 없음");
    else System.out.print("소수 마스터 갓규성");
  }

  // 소수가 아닐 경우
  private static void isNotDecimal(int turn) {
    if (turn == 0) {  // 대웅이가 소수가 아닌 수를 말함
      if (pq[1].size() < 3) {
        score[1] +=1000;
      } else {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(pq[1].poll());
        temp.add(pq[1].poll());
        score[1] += pq[1].peek();

        pq[1].offer(temp.poll());
        pq[1].offer(temp.poll());
      }
    } else {  // 경수가 소수가 아닌 수를 말함
      if (pq[0].size() < 3) {
        score[0] += 1000;
      } else {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(pq[0].poll());
        temp.add(pq[0].poll());
        score[0] += pq[0].peek();

        pq[0].offer(temp.poll());
        pq[0].offer(temp.poll());
      }
    }
  }

  // 소수일 경우
  private static void isDecimal(int num, int turn) {
    if (!decimalSet.contains(num)) {
      decimalSet.add(num);
      pq[turn].offer(num);
    } else {
      score[turn] -= 1000;
    }
  }

  // 소수인지 확인하기
  private static void checkDecimal(int num, int turn) {
    if (check[num]) {
      isDecimal(num, turn);
    } else {
      isNotDecimal(turn);
    }
  }

  private static void eratos() {
    for (int index = 2; index * index < check.length; index++) {
      if (check[index]) {
        for (int j = index * index; j < check.length; j += index) {
          check[j] = false;
        }
      }
    }
  }


  private static void initialize() {
    score = new long[2];

    check = new boolean[5000000];
    Arrays.fill(check, true);
    check[0] = false;
    check[1] = false;

    decimalSet = new HashSet<>();
    pq[0] = new PriorityQueue<>(Comparator.reverseOrder());
    pq[1] = new PriorityQueue<>(Comparator.reverseOrder());
  }
}
