package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon20438 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 학생 수
    int k = Integer.parseInt(st.nextToken());       // 조는 학생 수
    int q = Integer.parseInt(st.nextToken());       // 출석 코드를 받는 학생 수
    int m = Integer.parseInt(st.nextToken());       // 학생 구간

    // 학생 구간 생성
    HashSet<Integer> student = new HashSet<>();
    for (int i = 3; i <= n + 2; i++) student.add(i);

    st = new StringTokenizer(br.readLine());
    // 조는 학생 sleep에 추가
    HashSet<Integer> sleep = new HashSet<>();
    for (int i = 0; i < k; i++) {
      int num = Integer.parseInt(st.nextToken());

      sleep.add(num);
    }

    st = new StringTokenizer(br.readLine());
    // 출석 코드를 받는 학생 set에서 제거
    for (int i = 0; i < q; i++) {
      // 출석 코드를 받는 학생
      int getNum = Integer.parseInt(st.nextToken());


      if (!student.contains(getNum) || sleep.contains(getNum)) continue;

      student.remove(getNum);

      for (int j = 2; getNum * j <= n + 2; j++) {
        int check = getNum * j;        // 출석 코드를 받는 학생 번호
        if (!student.contains(check) || sleep.contains(check)) continue;

        student.remove(check);
      }
    }

    HashMap<Integer, Integer> answer = new HashMap<>();
    int count = 0;
    for (int i = 2; i <= n + 2; i++) {
      if (student.contains(i)) count++;

      answer.put(i, count);
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());       // 시작하는 구간
      int e = Integer.parseInt(st.nextToken());       // 끝나는 구간

      System.out.println(answer.get(e) - answer.get(s - 1));
    }
  }
}
