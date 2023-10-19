package beakjoon.algorithm.implementation;
/*
문제
- 나는 7번의 수능 끝에 한양대학교 23학번으로 입학하게 된 김한양이다. 
  한양대학교 추가합격 전화를 받고 기뻐서 친구들과 술을 마시며 길을 걷다가 언덕 아래로 굴러 떨어지고 말았다. 
  깨어나보니 2주가 흘러 있었고, 수강신청까지는 15분밖에 남지 않았다. 
  수강신청 홈페이지에 들어갔지만 부상의 후유증으로 학번이 기억나지 않았다. 
  한양대학교 공지사항을 확인해보니 학번을 생성하는 방법에 대한 안내문이 있었다.
  한양대학교는 Engine of Korea라고 불리는 만큼 학번을 만들 때 특수한 공식을 사용한다. 
  기본적으로 한양대학교 학번을 알아내기 위해서는 정확한 수능 점수(표준 점수)를 알고 있어야 한다.
    국어 점수가 영어 점수보다 높다면, 두 점수의 차에 인문관의 건물 번호 508을 곱해준다. 
    아니라면, 두 점수의 차에 국제관의 건물 번호 108을 곱해준다.
    수학 점수가 탐구 점수보다 높다면, 두 점수의 차에 제1공학관의 건물 번호 212를 곱해준다. 
    아니라면, 두 점수의 차에 ITBT관의 건물 번호 305을 곱해준다.
    제2외국어를 응시했다면 제2외국어 점수에 행원파크 건물 번호인 707을 곱해준다.
  위에서 계산한 세 값을 더한 뒤, 한양대학교의 우편번호 04763 (= 4763)을 곱하면 학번이 나온다.
  위의 계산을 하려던 김한양은 머리를 다쳐서 암산이 안 된다는 것을 깨닫고 
  당신에게 학번을 계산해주는 프로그램을 만들어 달라고 부탁하였다. 
  김한양의 학번을 계산해줄 프로그램을 만들어라! 
  단, 앞의 과목을 응시하지 않으면 뒤의 과목을 응시할 수 없는 구조이며, 응시하지 않은 과목의 표준점수는 0점이라고 가정하자.
입력
- 첫째 줄에 김한양이 응시한 과목 수를 나타내는 정수 T (1 <= T <= 5)가 주어진다. 
  둘째 줄에 각 과목의 표준점수를 나타내는 T개의 정수가 공백으로 구분되어 주어진다. 
  점수는 국어, 수학, 영어, 탐구, 제2외국어 순서로 주어지며, 탐구 과목의 점수는 두 과목의 표준점수의 합이 주어진다. 
  모든 과목의 점수는 0 이상 200 이하의 정수이다.
출력
- 김한양의 학번을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon29807 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] grades = new int[5];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) grades[i] = Integer.parseInt(st.nextToken());

    int num = 0;
    if (grades[0] > grades[2]) num += (grades[0] - grades[2]) * 508;
    else num += (grades[2] - grades[0]) * 108;

    if (grades[1] > grades[3]) num += (grades[1] - grades[3]) * 212;
    else num += (grades[3] - grades[1]) * 305;

    num += grades[4] * 707;

    System.out.println(num * 4763);
  }
}
