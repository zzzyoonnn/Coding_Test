package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21921 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 블로그 시작 일수
    int x = Integer.parseInt(st.nextToken());       // 기준 기간
    int[] visitor = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      visitor[i] = Integer.parseInt(st.nextToken());
    }

    int totalVisitor = 0;
    for (int i = 0; i < x; i++) {
      totalVisitor += visitor[i];
    }

    int period = 1;                     // 최대 방문자 수가 동일한 기간의 개수
    int maxVisitor = totalVisitor;      // 최대 방문자 수
    for (int i = 0; i < visitor.length - x; i++) {
      totalVisitor += visitor[i + x];
      totalVisitor -= visitor[i];

      if (maxVisitor < totalVisitor) {
        period = 1;
        maxVisitor = totalVisitor;
      } else if (maxVisitor == totalVisitor) {
        period++;
      }
    }

    StringBuilder sb = new StringBuilder();
    if (maxVisitor == 0) {              // 최대 방문자 수가 0이라면
      sb.append("SAD");
    } else {                            // 최대 방문자 수가 0이 아니라면
      sb.append(maxVisitor).append('\n');
      sb.append(period).append('\n');
    }
    System.out.println(sb);
  }
}