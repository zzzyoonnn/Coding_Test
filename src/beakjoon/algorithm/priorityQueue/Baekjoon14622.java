package beakjoon.algorithm.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon14622 {
  static int turn;
  static boolean[] check;
  static long score;
  static HashSet<Integer> decimalSet = new HashSet<>();
  static PriorityQueue<Integer> dwDecimal;
  static PriorityQueue<Integer> gsDecimal;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 라운드 수

    initialize();

    StringTokenizer st;
    for (turn = 1; turn <= N; turn++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

//      System.out.println(d + " " + g);
//      System.out.print(check[d] + " " + check[g]);
//      System.out.println(decimalSet);
      checkDecimal(d, dwDecimal);
      checkDecimal(g, gsDecimal);

    }

    if (score > 0) System.out.print("소수의 신 갓대웅");
    else if (score == 0) System.out.print("우열을 가릴 수 없음");
    else System.out.print("소수 마스터 갓규성");
  }

  // 소수가 아닐 경우
  private static void isNotDecimal(PriorityQueue<Integer> pq) {
    if (pq.equals(dwDecimal)) {  // 대웅이가 소수가 아닌 수를 말함
      if (gsDecimal.size() >= 3) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(gsDecimal.poll());
        temp.add(gsDecimal.poll());
        score -= gsDecimal.poll();

        gsDecimal.offer(temp.poll());
        gsDecimal.offer(temp.poll());
      } else {
        score -= 1000;
      }
    } else {  // 경수가 소수가 아닌 수를 말함
      if (dwDecimal.size() >= 3) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(dwDecimal.poll());
        temp.add(dwDecimal.poll());
        score += dwDecimal.poll();

        dwDecimal.offer(temp.poll());
        dwDecimal.offer(temp.poll());
      } else {
        score += 1000;
      }
    }
  }

  // 소수일 경우
  private static void isDecimal(int num, PriorityQueue<Integer> pq) {
    if (!decimalSet.contains(num)) {
//      System.out.println("소수 추가" + num);
      decimalSet.add(num);
//      System.out.println(decimalSet);
      pq.offer(num);
    } else {
      if (pq.equals(dwDecimal)) score -= 1000;
      else score += 1000;
    }
  }

  // 소수인지 확인하기
  private static void checkDecimal(int num, PriorityQueue<Integer> pq) {
    if (check[num]) {
      isDecimal(num, pq);
    } else {
      isNotDecimal(pq);
    }
  }


  private static void initialize() {
    score = 0;

    check = new boolean[5000000];
    Arrays.fill(check, true);
    check[0] = false;
    check[1] = false;
    for (int index = 2; index * index < check.length; index++) {
      if (check[index]) {
        for (int j = index * index; j < check.length; j += index) {
          check[j] = false;
        }
      }
    }

    dwDecimal = new PriorityQueue<>(Comparator.reverseOrder());
    gsDecimal = new PriorityQueue<>(Comparator.reverseOrder());
  }
}
