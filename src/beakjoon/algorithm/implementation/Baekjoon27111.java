package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon27111 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 출입 기록의 개수

    HashSet<Integer> record = new HashSet<>();

    int count = 0;
    int num, type;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      num = Integer.parseInt(st.nextToken());
      type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        if (record.contains(num)) count++;
        else record.add(num);
      } else if (type == 0) {
        if (!record.contains(num)) count++;
        else record.remove(num);
      }
    }

    count += record.size();

    System.out.println(count);
  }
}
