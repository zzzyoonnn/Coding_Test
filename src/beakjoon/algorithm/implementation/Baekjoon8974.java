package beakjoon.algorithm.implementation;
/*
문제
- 강민이 동생 희주는 올해 초등학교에 입학했다. 
  며칠 있으면, 생애 첫 시험을 보게 될텐데, 수학시험도 같이 본다고 한다.
  희주는 겁을 먹은 나머지, 열심히 준비해야겠다고 생각했다. 
  이를 본 오빠 강민이는 동생 희주를 위해 작은 도움을 주고자 한다.
  연습문제 중에 하나가 정수를 적어나가는 것이였는데 수열은 1이 한 개, 2가 두 개, 3이 세 개.. 와 같이 만들어진다.
  이제 강민이는 희주에게 두 개의 정수 A, B를 부를텐데, 그럼 희주는 주어진 수열에서 A번째와 B번째 사이에 있는 모든 수들의 합을 말해야한다.
  예를 들면, A가 1이고 B는 3이라면 답은 처음 세 개의 정수를 더한 1+2+2 = 5 가 된다.
  희주에게 문제를 내기 위해 정답을 계산하는 프로그램을 작성하시오.
입력
- 한 줄에 양의 정수 A와 B가 주어진다. (1 ≤ A ≤ B ≤ 1000)
출력
- 희주가 대답해야 할 정답을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon8974 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int count = 0;
    int sum = 0;
    for (int i = 1; i <= b; i++) {
      for (int j = 1; j <= i; j++) {
        count++;
        if (count >= a && count <= b) sum += i;
      }
    }
    System.out.println(sum);
  }
}
