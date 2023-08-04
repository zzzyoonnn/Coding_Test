package beakjoon.algorithm.string;
/*
문제
- 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 
  전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다. 
  그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
  치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
  전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
  인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.
    A+  4.5
    A0  4.0
    B+  3.5
    B0  3.0
    C+  2.5
    C0  2.0
    D+  1.5
    D0  1.0
    F   0.0
  P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
  과연 치훈이는 무사히 졸업할 수 있을까?
입력
- 20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
출력
- 치훈이의 전공평점을 출력한다.
  정답과의 절대오차 또는 상대오차가 10^-4 이하이면 정답으로 인정한다.
ex 1)
입력                                          출력
- ObjectOrientedProgramming1 3.0 A+           - 3.284483
  IntroductiontoComputerEngineering 3.0 A+
  ObjectOrientedProgramming2 3.0 A0
  CreativeComputerEngineeringDesign 3.0 A+
  AssemblyLanguage 3.0 A+
  InternetProgramming 3.0 B0
  ApplicationProgramminginJava 3.0 A0
  SystemProgramming 3.0 B0
  OperatingSystem 3.0 B0
  WirelessCommunicationsandNetworking 3.0 C+
  LogicCircuits 3.0 B0
  DataStructure 4.0 A+
  MicroprocessorApplication 3.0 B+
  EmbeddedSoftware 3.0 C0
  ComputerSecurity 3.0 D+
  Database 3.0 C+
  Algorithm 3.0 B0
  CapstoneDesigninCSE 3.0 B+
  CompilerDesign 3.0 D0
  ProblemSolving 4.0 P
ex 2)
입력                      출력
- BruteForce 3.0 F        - 0.000000
  Greedy 1.0 F
  DivideandConquer 2.0 F
  DynamicProgramming 3.0 F
  DepthFirstSearch 4.0 F
  BreadthFirstSearch 3.0 F
  ShortestPath 4.0 F
  DisjointSet 2.0 F
  MinimumSpanningTree 2.0 F
  TopologicalSorting 1.0 F
  LeastCommonAncestor 2.0 F
  SegmentTree 4.0 F
  EulerTourTechnique 3.0 F
  StronglyConnectedComponent 2.0 F
  BipartiteMatching 2.0 F
  MaximumFlowProblem 3.0 F
  SuffixArray 1.0 F
  HeavyLightDecomposition 4.0 F
  CentroidDecomposition 3.0 F
  SplayTree 1.0 F
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25206 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    float totalCredit = 0;
    float creditScore = 0;

    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      float credit = 0; // 학점
      double score = 0;  // 평점
      String s = st.nextToken();
      credit = Float.parseFloat(st.nextToken());
      String grade = st.nextToken();    // 성적

      if (grade.equals("A+")) score = 4.5;
      else if (grade.equals("A0")) score = 4.0;
      else if (grade.equals("B+")) score = 3.5;
      else if (grade.equals("B0")) score = 3.0;
      else if (grade.equals("C+")) score = 2.5;
      else if (grade.equals("C0")) score = 2.0;
      else if (grade.equals("D+")) score = 1.5;
      else if (grade.equals("D0")) score = 1.0;
      else if (grade.equals("F")) score = 0.0;
      else {
        score = 0;
        credit = 0;
      }

      totalCredit += credit;
      creditScore += credit * score;
    }

    float average = creditScore / totalCredit;
    System.out.printf("%.6f\n", average);
  }
}
