package beakjoon.Step.step12;
/*
문제
- 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
  이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 
  이 때, 상을 받는 커트라인이 몇 점인지 구하라.
  커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
입력
- 첫째 줄에는 응시자의 수 N과 
  상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
  둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
출력
- 상을 받는 커트라인을 출력하라.
ex 1)
입력
- 5 2
  100 76 85 93 98
출력
- 98
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon25305 {

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 입력받은 값을 띄어쓰기 기준으로 토큰화
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 띄어쓰기 기준으로 토근화된 값들을 하나씩 변수에 입력
    int total = Integer.parseInt(st.nextToken());	// 응시자 수
    int prize = Integer.parseInt(st.nextToken());	// 상 받는 사람 수

    // 응시자 수만큼의 배열 생성
    Integer arr[] = new Integer[total];
    // 값 입력받기
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < total; i++) {
      // 입력받은 값을 띄어쓰기 기준으로 토큰화
      // 띄어쓰기 기준으로 토근화된 값들을 하나씩 변수에 입력
      int n = Integer.parseInt(st.nextToken());
      arr[i] = n;
    }

    Arrays.sort(arr, Collections.reverseOrder());
    // Arrays.sort()
    // 자바에서 기본으로 제공되는 메소드
    // 자체 정렬 알고리즘을 구현할 필요 없이 sort() 안에 배열을 넣어주면
    // 자동으로 배열이 정렬되어 나옴
    // Arrays.sort(arr, Collections.reverseOrder()); 내림차순 정렬
    // 내림차순 정렬 사용 시 
    // 선언할 때 Integer arr[] = new Integer[n]

    System.out.println(arr[prize-1]);	// 평균 출력
  }
}
