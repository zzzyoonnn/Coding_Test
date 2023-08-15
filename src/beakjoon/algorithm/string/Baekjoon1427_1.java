package beakjoon.algorithm.string;
/*
문제
- 배열을 정렬하는 것은 쉽다. 
  수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
입력
- 첫째 줄에 정렬하려고 하는 수 N이 주어진다. 
  N은 1,000,000,000보다 작거나 같은 자연수이다.
출력
- 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
ex 1)
입력		출력
- 2143      - 4321
ex 2)
입력          출력
- 999998999   - 999999998
ex 3)
입력        출력
- 61423     - 64321
ex 4)
입력            출력
- 500613009     - 965310000
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon1427_1 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st = br.readLine();
    Integer[] arr = new Integer[st.length()];

    for (int i = 0; i < st.length(); i++) {
      arr[i] = Integer.parseInt(Character.toString(st.charAt(i)));
    }

    Arrays.sort(arr, Collections.reverseOrder());

    for (int i = 0; i < st.length(); i++) {
      System.out.print(arr[i]);
    }
  }
}
