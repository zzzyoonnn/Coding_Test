package beakjoon.algorithm.implementation;
/*
문제
- 승현이가 일하는 햄버거 가게에는 요리 재료로 사용할 햄버거 패티가 A개, 슬라이스 치즈가 B개 있다. 
  치즈버거를 만들기 위해서는 패티와 치즈를 각각 한 개 이상 고른 후 햄버거 빵 사이에 패티와 치즈를 번갈아 쌓아야 한다. 
  단, 패티의 개수는 치즈의 개수보다 정확히 한 개 더 많이 골라야 한다.
  승현이는 가게에 있는 요리 재료를 가지고 최대한 큰 치즈버거를 하나 만들려고 한다. 
  치즈버거의 크기는 패티와 치즈의 개수를 더한 것과 같다. 
  승현이가 만들 수 있는 치즈버거의 최대 크기를 구해보자.
입력
- 첫째 줄에 패티의 개수 A(2 <= A <= 100)와 치즈의 개수 B(1 <= B <= 100)가 공백으로 구분되어 주어진다.
출력
- 승현이가 만들 수 있는 치즈버거의 최대 크기를 출력한다.
ex 1)
입력		출력
- 2 1       - 3
ex 2)
입력        출력
- 4 5       - 7
ex 3)
입력        출력
- 3 3       - 5
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon30017 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int patty = Integer.parseInt(st.nextToken());
    int cheese = Integer.parseInt(st.nextToken());

    if (patty > cheese) System.out.println(cheese + cheese + 1);
    else System.out.println(patty + patty - 1);

  }
}
