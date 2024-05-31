package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2891 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());       // 팀의 수
    int s = Integer.parseInt(st.nextToken());       // 카약이 손상된 팀의 수
    int r = Integer.parseInt(st.nextToken());       // 카약을 하나 더 가져온 팀의 수

    // 카약의 상태를 저장할 boolean 배열(true: 정상, false: 손상)
    boolean[] check = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      check[i] = true;
    }

    // 카약이 손상된 팀
    int num = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < s; i++) {
      num = Integer.parseInt(st.nextToken());
      check[num] = false;
    }

    // 카약을 하나 더 가져온 팀
    ArrayList<Integer> list = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < r; i++) {
      num = Integer.parseInt(st.nextToken());
      list.add(num);            // 여분의 카약을 가져온 팀을 list에 추가

      if (!check[num]) {                        // 카약이 손상된 팀이 여분의 카약이 있는 경우
        check[num] = true;                      // 카약의 상태가 정상
        list.remove(Integer.valueOf(num));      // list에서 제거
      }
    }

    // 여분의 카약이 남은 팀 순회
    for (int i = 0; i < list.size(); i++) {
      num = list.get(i);        // 여분의 카약 보유 팀 번호
      if (!check[num - 1]) {    // 앞팀에 카약 대여
        check[num - 1] = true;
      } else if (num + 1 <= n && !check[num + 1]) {     // 뒷팀에 카약 대여
        check[num + 1] = true;
      }
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {      // 팀을 순회하며
      if (!check[i]) count++;           // 카약의 상태가 손상되었다면 count++;
    }
    System.out.println(count);
  }
}
