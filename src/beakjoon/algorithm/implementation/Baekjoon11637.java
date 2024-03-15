package beakjoon.algorithm.implementation;
/*
문제
- 한국에서 나이는 총 3가지 종류가 있다.
    만 나이: 국제적인 표준 방법이다. 한국에서도 법에서는 만 나이만을 사용한다.
    세는 나이: 한국에서 보통 나이를 물어보면 세는 나이를 의미한다.
    연 나이: 법률에서 일괄적으로 사람을 구분하기 위해서 사용하는 나이이다.
  만 나이는 생일을 기준으로 계산한다. 
  어떤 사람이 태어났을 때, 그 사람의 나이는 0세이고, 생일이 지날 때마다 1세가 증가한다. 
  예를 들어, 생일이 2003년 3월 5일인 사람은 2004년 3월 4일까지 0세이고, 2004년 3월 5일부터 2005년 3월 4일까지 1세이다.
  세는 나이는 생년을 기준으로 계산한다. 
  어떤 사람이 태어났을 때, 그 사람의 나이는 1세이고, 연도가 바뀔 때마다 1세가 증가한다. 
  예를 들어, 생일이 2003년 3월 5일인 사람은 2003년 12월 31일까지 1세이고, 2004년 1월 1일부터 2004년 12월 31일까지 2세이다.
  연 나이는 생년을 기준으로 계산하고, 현재 연도에서 생년을 뺀 값이다. 
  예를 들어, 생일이 2003년 3월 5일인 사람은 2003년 12월 31일까지 0세이고, 2004년 1월 1일부터 2004년 12월 31일까지 1세이다.
  어떤 사람의 생년월일과 기준 날짜가 주어졌을 때, 
  기준 날짜를 기준으로 그 사람의 만 나이, 세는 나이, 연 나이를 모두 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 어떤 사람이 태어난 연도, 월, 일이 주어진다. 
  생년월일은 공백으로 구분되어져 있고, 항상 올바른 날짜만 주어진다.
  둘째 줄에 기준 날짜가 주어진다. 
  기준 날짜도 공백으로 구분되어져 있으며, 올바른 날짜만 주어진다.
  입력으로 주어지는 생년월일은 기준 날짜와 같거나 그 이전이다.
  입력으로 주어지는 연도는 1900년보다 크거나 같고, 2100년보다 작거나 같다.
출력
- 첫째 줄에 만 나이, 둘째 줄에 세는 나이, 셋째 줄에 연 나이를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11637 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int year = Integer.parseInt(st.nextToken());        // 생년
    int month = Integer.parseInt(st.nextToken());       // 월
    int date = Integer.parseInt(st.nextToken());        // 일

    st = new StringTokenizer(br.readLine());
    int standard_year = Integer.parseInt(st.nextToken());   // 기준년도
    int standard_month = Integer.parseInt(st.nextToken());  // 기준월
    int standard_date = Integer.parseInt(st.nextToken());   // 기준일

    int age1 = 0;   // 만 나이
    int age2 = 0;   // 세는 나이
    int age3 = 0;   // 연 나이

    int n = standard_year - year + 1;

    // 만 나이 계산
    if (standard_month > month) {       // 만 나이 기준일 지남
      age1 = standard_year - year;
    } else if (standard_month == month) {
      if (standard_date >= date) {           // 만 나이 기준일 지남
        age1 = standard_year - year;
      } else {
        age1 = standard_year - year - 1;
      }
    } else {
      age1 = standard_year - year - 1;
    }

    // 세는 나이
    age2 = n;

    // 연 나이
    age3 = n - 1;

    System.out.println(age1);
    System.out.println(age2);
    System.out.println(age3);
  }
}
