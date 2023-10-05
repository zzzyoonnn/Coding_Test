package beakjoon.algorithm.implementation;
/*
문제
- 혜성처럼 나타난 브실컵의 아이돌 브실이를 보기 위해 전국 각지의 사람들이 천문대로 모였다. 
  브실이에게 "혜성처럼 나타난" 이라는 수식어가 붙은 이유는 혜성처럼 주기적으로 관측할 수 있기 때문이라고 한다. 
  오늘 브실이를 볼 수 있다고 할 때, 브실이를 다시 볼 수 있는 날짜를 구하자.
  편의를 위해 이 문제에서 한 달은 30일, 1년은 12달(즉, 1년은 360일)로 가정하자.
입력
- 첫 번째 줄에 오늘 날짜가 yyyy-mm-dd 형식으로 주어진다. 
  (1,000 <= yyyy <= 3,000; 1 <= mm <= 12; 1 <= dd <= 30) 
  두 번째 줄에 정수 N이 주어진다. 
  이것은 브실이를 N일 주기로 볼 수 있다는 의미이다. (1 <= N <= 1,000,000) 
출력
- 오늘 이후에 브실이를 볼 수 있는 가장 이른 날짜를 yyyy-mm-dd 형태로 출력한다.
ex 1)
입력		    출력
- 2023-07-08    - 2023-08-08
  30
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon29722 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(),"-");
    int year = Integer.parseInt(st.nextToken());
    int month = Integer.parseInt(st.nextToken());
    int date = Integer.parseInt(st.nextToken());
    int early = Integer.parseInt(br.readLine());
    date += early;
    while (date > 30) {
      date -= 30;
      month++;
    }

    while (month > 12) {
      month -= 12;
      year++;
    }
    System.out.print(year + "-" + String.format("%02d",month) + "-" + String.format("%02d", date));
  }
}
