package beakjoon.Type.BruteForce;
/*
문제
- 하루에 한 시간 단위로 일을 하거나 일을 쉬어도 된다. 
  하루에 한 시간 일하면 피로도는 A만큼 쌓이고 일은 B만큼 처리할 수 있다.
  만약에 한 시간을 쉰다면 피로도는 C만큼 줄어든다. 
  단, 피로도가 음수로 내려가면 0으로 바뀐다. 
  당연히 일을 하지 않고 쉬었기 때문에 처리한 일은 없다.
  피로도를 최대한 M을 넘지 않게 일을 하려고 한다. 
  M을 넘기면 일하는데 번아웃이 와서 이미 했던 일들도 다 던져버리고 일을 그만두게 된다.
  번아웃이 되지 않도록 일을 할때 하루에 최대 얼마나 일을 할 수 있는지 구해보자. 
  하루는 24시간이다.
입력
- 첫 번째 줄에 네 정수 A, B, C, M이 공백으로 구분되어 주어진다.
  맨 처음 피로도는 0이다.
출력
- 하루에 번 아웃이 되지 않도록 일을 할 때 최대 얼마나 많은 일을 할 수 있는지 출력한다.
ex 1)
입력          출력
- 5 3 2 10    - 24
ex 2)
입력          출력
- 10 5 1 10   - 15
ex 3)
입력          출력
- 11 5 1 10   - 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon22864 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());   // 한시간 피로도
    int b = Integer.parseInt(st.nextToken());   // 한시간 처리량
    int c = Integer.parseInt(st.nextToken());   // 한시간 휴식
    int m = Integer.parseInt(st.nextToken());   // 피로도 한계

    int fatigue = 0;    // 피로도
    int quantity = 0;   // 한 일의 양

    for (int i = 0; i < 24; i++) {
      if (fatigue + a <= m) {
        fatigue += a;
        quantity += b;
      } else {
        fatigue -= c;

        if (fatigue < 0) fatigue = 0;
      }
    }
    System.out.println(quantity);
  }
}
