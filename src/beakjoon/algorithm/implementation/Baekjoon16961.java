package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon16961 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] days = new int[367];              // 윤년(366일) + 1
    boolean[] check = new boolean[367];     // 투숙 확인용
    int[] checkT = new int[367];            // 탭파
    int[] checkS = new int[367];            // 공백파

    int n = Integer.parseInt(br.readLine());        // 예약한 사람 수
    StringTokenizer st;

    int day = 0;                // 투숙객이 1명 이상인 날의 수
    int maxPeople = -1;         // 가장 많은 투숙객이 있었던 날에 투숙한 사람의 수
    int maxDay = -1;            // 가장 오랜 기간 투숙한 사람의 투숙 기간
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String type = st.nextToken();
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      for (int j = start; j <= end; j++) {
        if (!check[j]) day++;
        days[j] = ++days[j];
        check[j] = true;
        if (type.equals("T")) checkT[j]++;
        if (type.equals("S")) checkS[j]++;
        maxPeople = Math.max(maxPeople, days[j]);
      }

      maxDay = Math.max(maxDay, end - start + 1);
    }

    int noFighting = 0;             // 싸움이 없는 날의 수
    int noFightingPeople = 0;       // 싸움이 없는 날 중 가장 많은 투숙객이 있었던 날에 투숙한 사람의 수
    for (int i = 1; i < check.length; i++) {
      if (checkT[i] == checkS[i] && checkT[i] != 0 && checkS[i] != 0) {
        noFighting++;
        noFightingPeople = Math.max(noFightingPeople, days[i]);
      }
    }

    System.out.println(day);                    // 1. 투숙객이 1명 이상인 날의 수
    System.out.println(maxPeople);              // 2. 가장 많은 투숙객이 있었던 날에 투숙한 사람의 수
    System.out.println(noFighting);             // 3. 싸움이 없는 날의 수
    System.out.println(noFightingPeople);       // 4. 싸움이 없는 날 중 가장 많은 투숙객이 있었던 날에 투숙한 사람의 수
    System.out.println(maxDay);                 // 5. 가장 오랜 기간 투숙한 사람이 투숙한 날의 수
  }
}
