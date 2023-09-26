package beakjoon.algorithm.implementation;
/*
문제
- 서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.
입력
- 입력은 없다.
출력
- 서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
ex 1)
출력
- 2015-01-24
 */
import java.time.LocalDate;

public class Baekjoon10699 {
  public static void main(String[] agrs) {
    LocalDate date = LocalDate.now();
    System.out.println(date);
  }
}
