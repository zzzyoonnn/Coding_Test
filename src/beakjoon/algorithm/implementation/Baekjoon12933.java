package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12933 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    char[] arr = s.toCharArray();       // O(n)

    char[] quack = {'q', 'u', 'a', 'c', 'k'};

    // Checking if the length is divisible by 5 : O(1)
    if (arr.length % 5 != 0) {
      System.out.print(-1);
      System.exit(0);
    }

    int length = arr.length;    // 남아있는 소리의 길이
    int count = 0;              // 오리 수
    while (length != 0) {
      int indexQ = 0;           // quack 소리의 순서
      int indexA = 0;           // 문자열 시작 위치

      boolean check = false;
      int[] position = new int[5];      // quack 소리의 위치를 저장하는 배열

      // O((n / 5) * n) = O(n^2 / 5) = O(n^2)
      while (indexA < arr.length) {
        if (arr[indexA] == quack[indexQ]) {     // quack 소리의 문자와 주어진 문자열의 indexA번째 문자가 같다면
          position[indexQ++] = indexA;          // quack 소리 저장

          if (indexQ == 5) {        // quack 소리를 다 찾았다면
            check = true;
            length -= 5;            // 남아있는 소리의 길이 quack만큼 제거
            indexQ = 0;             // quack를 처음부터 순회하기 위해

            for (int i = 0; i < 5; i++) arr[position[i]] = ' ';     // 확인된 오리 소리 공란으로 변경
          }
        }

        indexA++;       // 문자열 시작 위치 증가
      }
      if (check) count++;
      else {
        System.out.print(-1);
        System.exit(0);
      }
    }

    System.out.println(count);
  }
}
