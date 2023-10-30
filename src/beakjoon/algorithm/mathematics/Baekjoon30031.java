package beakjoon.algorithm.mathematics;
/*
문제
- 대한민국 지폐는 천 원권, 오천 원권, 만 원권, 오만 원권으로 총 네 종류가 있다. 
  각 지폐의 세로 길이는 68mm로 모두 같지만, 가로 길이는 모두 다르다. 
  천 원권의 가로 길이는 136mm, 오천 원권의 가로 길이는 142mm, 
  만 원권의 가로 길이는 148mm, 오만 원권의 가로 길이는 154mm이다. 
  따라서 가로의 길이를 통해서 지폐의 종류를 구분할 수 있다.
  수민이는 대한민국 지폐 N장을 가지고 있다. 
  수민이는 종이의 크기를 재는 기계를 이용하여 각 지폐의 가로, 세로 길이를 알아냈다. 
  수민이가 가진 지폐의 총액을 구해보자.
입력
- 첫째 줄에 정수 N(1 <= N <= 100)이 주어진다.
  둘째 줄부터 N개의 줄에 각 지폐의 가로, 세로 길이가 공백으로 구분되어 mm단위로 주어진다. 
  주어지는 지폐의 가로, 세로 길이의 길이는 정수이고 천 원권, 오천 원권, 만 원권, 오만 원권의 가로, 세로 길이 중 하나이다.
출력
- 수민이가 가진 지폐의 총액을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon30031 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int total = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      if (m == 136) total += 1000;
      else if (m == 142) total += 5000;
      else if (m == 148) total += 10000;
      else if (m == 154) total += 50000;
    }
    System.out.println(total);
  }
}
