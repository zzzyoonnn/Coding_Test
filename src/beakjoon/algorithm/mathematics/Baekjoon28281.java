package beakjoon.algorithm.mathematics;
/*
문제
- N일 뒤는 동원이의 생일이다. 축하해 주자!
  준원이는 동원이에게 생일 선물로 양말을 2X개 선물하려 한다. 
  양말은 시장에서 살 것이다. 
  연속한 이틀에 걸쳐서, 준원이는 매일 시장에서 양말을 X개씩 사서 트럭에 담아올 것이다.
  시장에서 양말의 가격은 날마다 다를 수 있다. 
  오늘부터 i번째 날에, 양말은 하나에 Ai원이다.
  동원이의 생일까지 N일 남았다! 
  남은 N일 가운데 연속한 이틀에 걸쳐 양말 2X개를 사는 데 드는 최소 비용은?
입력
- 첫째 줄에 N과 X가 공백을 사이에 두고 주어진다.
  둘째 줄에 N일간 양말의 가격 A1, A2, ..., AN이 공백을 사이에 두고 주어진다.
출력
- 연속한 이틀에 걸쳐 하루에 양말을 X개씩 구매하는 방법으로, 
  양말 2X개를 사는 데 드는 최소 비용을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon28281 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] socks = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      socks[i] = Integer.parseInt(st.nextToken());
    }

    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      int temp = (x * socks[i - 1]) + (x * socks[i]);
      if (min > temp) min = temp;
    }

    System.out.println(min);
  }
}
