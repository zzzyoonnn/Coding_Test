package beakjoon.Step.step01;
/*
문제
- (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
		  4 7 2	.....(1)
		X 3 8 5 .....(2)
	---------------------
		2 3 6 0 .....(3)	
	  3 7 7 6	.....(4)	
	1 4 1 6		.....(5)
	---------------------
	1 8 1 7 2 0 .....(6)
- (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때
  (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가,
  둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
출력
- 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
ex 1)
입력          
- 472
  385
출력
- 2360
  3776
  1416
  181720
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjoon2588 {
  public static void main(String[] args) throws IOException{
    int a, b;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 띄어쓰기를 기준으로 값을 입력 받으므로
    // parseInt에 readLine()을 한다.
    a = Integer.parseInt(br.readLine());
    b = Integer.parseInt(br.readLine());

    // 두번째 입력받은 세자리 수를 10으로 나누어 나머지를 구해 
    // 첫번째 세자리 수와 두번째 세자리 수의 일의 자리수만 곱한다.
    System.out.println(a * (b % 10));

    // 두번째 세자리 수를 100으로 나누어 나머지를 구해
    // 10의 자리 수와 1의 자리 수를 구하고
    // 10의 자리 수와 1의 자리 수를 10으로 나누어
    // 첫번째 세자리수와 두번째 세자리 수의 10의 자리 수만 곱한다.
    System.out.println(a * (b % 100 / 10));

    // 두번째 세자리 수를 100으로 나누어
    // 첫번째 세자리 수와 두번째 세자리 수의 100의 자리를 곱한다.
    System.out.println(a * (b / 100));

    // 첫번째 세자리 수와 두번째 세자리 수의 곱셈 결과를 출력한다.
    System.out.println(a * b);
  }
}
